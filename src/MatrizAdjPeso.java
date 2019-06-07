import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author mathe
 */
public class MatrizAdjPeso {

    private final LinkedList<LinkedList<Float>> matrizAdjPeso = new LinkedList();
    private final LinkedList<LinkedList<Float>> listaAdjPeso = new LinkedList();;
    private  int V = 0; //Maior numero dos vertices

    public MatrizAdjPeso(ArrayList<Float> listaElementosPeso){
        initListaAdjPeso(listaElementosPeso);
        initMatrizAdjPeso();
        setMatrizAdjPeso();

    }

    private void initMatrizAdjPeso(){
        for (int i = 0; i < V; i++) {
            matrizAdjPeso.add(new LinkedList());
            for (int j = 0; j < V; j++) {
                matrizAdjPeso.get(i).add((float)0);
            }
        }
    }

    private void initListaAdjPeso(ArrayList<Float> listaElementosPeso){
        int index = 0;
        listaAdjPeso.add(new LinkedList());
        for (int i = 0; i < listaElementosPeso.size(); i++) { /*para não contar o ultimo -1 da entrado de dados*/
            Float elemento = listaElementosPeso.get(i);
            if(elemento != -1){
                listaAdjPeso.get(index).add(elemento);
            }else{
                if(listaAdjPeso.get(index).get(0)>V) V = listaAdjPeso.get(index).get(0).intValue(); /*Verfica o maior vertice*/
                if(listaAdjPeso.get(index).get(1)>V) V = listaAdjPeso.get(index).get(1).intValue(); /*para saber a quantidade de vertices*/
                listaAdjPeso.add(new LinkedList());
                index++;
            }
        }
        listaAdjPeso.removeLast(); /*remove a ultima lista, porconta do ultimo -1 da entrada de dados*/
        V++; //Os vertices começam em zero, então o total de vertices é V + 1
    }



    private void setMatrizAdjPeso(){
        for (int i = 0; i < listaAdjPeso.size(); i++) {
            addAresta(listaAdjPeso.get(i).get(0).intValue(), listaAdjPeso.get(i).get(1).intValue(), listaAdjPeso.get(i).get(2));
        }
    }

    public void addAresta(int orig, int dest, Float peso){
        matrizAdjPeso.get(orig).set(dest, peso);
    }

    public void removerAresta(int orig, int dest){
        matrizAdjPeso.get(orig).set(dest, (float)0);
    }

    public void showMatriz(){
        for (int i = 0; i < matrizAdjPeso.size(); i++) {
            for (int j = 0; j < matrizAdjPeso.size(); j++) {
                System.out.printf("%.2f ", matrizAdjPeso.get(i).get(j));
            }
            System.out.println();
        }
    }

    public LinkedList<LinkedList<Float>> getMatrizAdjPeso(){
        return matrizAdjPeso;
    }
}