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
        util.initDado();
        System.out.println(util.getListaArestas());
        System.out.println(util.getQuantidadeVertices());
        MatrizAdjPeso matrizAdjPeso = new MatrizAdjPeso(util.getListaArestas(), util.getQuantidadeVertices());

        matrizAdjPeso.showMatriz();
//
//        Dijkstra dijkstra = new Dijkstra(matrizAdjPeso.getMatrizAdjPeso());
//        dijkstra.dijkstra(0);
//
        BellmanFord bellmanFord = new BellmanFord(matrizAdjPeso);
        bellmanFord.bellmanford(0);
    }
}

