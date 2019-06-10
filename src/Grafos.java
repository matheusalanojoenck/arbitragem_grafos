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
            int opcao;
            Scanner scanner = new Scanner(System.in);
            BellmanFord bellmanFord = new BellmanFord(matrizAdjPeso);

            do {
                System.out.println("Vertice de origem: ");
                opcao = scanner.nextInt();
                bellmanFord.bellmanford(opcao);
            } while (opcao != -1);
        }
    }
}

