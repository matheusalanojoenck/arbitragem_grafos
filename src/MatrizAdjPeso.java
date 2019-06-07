import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author mathe
 */
public class MatrizAdjPeso {

    private LinkedList<LinkedList<Float>> matrizAdjPeso = new LinkedList<>();
    private LinkedList<LinkedList<Float>> listaArestas;
    private int V; //Maior numero dos vertices

    public MatrizAdjPeso(LinkedList<LinkedList<Float>> listaArestas , int QntVertices){
        this.listaArestas = listaArestas;
        V = QntVertices;
        initMatrizAdjPeso();
        setMatrizAdjPeso();
    }

    private void initMatrizAdjPeso(){
        for (int i = 0; i < V; i++) {
            matrizAdjPeso.add(new LinkedList<>());
            for (int j = 0; j < V; j++) {
                matrizAdjPeso.get(i).add((float)0);
            }
        }
    }

    private void setMatrizAdjPeso(){
        for (int i = 0; i < listaArestas.size(); i++) {
            addAresta(listaArestas.get(i).get(0).intValue(), listaArestas.get(i).get(1).intValue(), listaArestas.get(i).get(2));
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

    public LinkedList<LinkedList<Float>> getListaArestas(){
        return listaArestas;
    }
}
