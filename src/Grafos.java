import java.util.Scanner;

/**
 * Alunos: Matheus Alano | Gabriel
 * @author mathe
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        Util util = new Util();
        if(util.initDado()){
            MatrizAdjPeso matrizAdjPeso = new MatrizAdjPeso(util.getListaArestas(), util.getQuantidadeVertices());
            int opcao = 0;
            Scanner scanner = new Scanner(System.in);
            BellmanFord bellmanFord = new BellmanFord(matrizAdjPeso);

            while (true){
                System.out.println("Vertice de origem: ");
                opcao = scanner.nextInt();
                if(opcao == -1) return;
                bellmanFord.bellmanford(opcao);
            }
        }
    }
}

