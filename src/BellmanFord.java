import java.util.LinkedList;

public class BellmanFord {

    private LinkedList<LinkedList<Float>> matrizAdjPeso;
    private LinkedList<LinkedList<Float>> listaArestas;

    public BellmanFord(MatrizAdjPeso matrizAdjPeso){
        this.listaArestas = matrizAdjPeso.getListaArestas();
        this.matrizAdjPeso = matrizAdjPeso.getMatrizAdjPeso();
    }

    // The main function that finds shortest distances from src
    // to all other vertices using Bellman-Ford algorithm.  The
    // function also detects negative weight cycle
    public void bellmanford(int origem) {

        int V = matrizAdjPeso.size(); //Quantidade de vertices
        int E = listaArestas.size(); //Quantidade de arestas

        float[] estimativa = new float[V];
        int[] precedente = new int[V];

        // Step 1: Initialize distances from src to all other
        // vertices as INFINITE
        for (int i=0; i<V; ++i) {
            estimativa[i] = Integer.MAX_VALUE;
        }
        estimativa[origem] = 0;

        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for (int i=1; i<V; ++i) {
            for (int j=0; j<E; ++j) {
                int u =        listaArestas.get(j).get(0).intValue();
                int v =        listaArestas.get(j).get(1).intValue();
                float peso = listaArestas.get(j).get(2);

                if (estimativa[u] != Integer.MAX_VALUE && estimativa[u]+peso<estimativa[v]){
                    estimativa[v] = estimativa[u]+peso;
                    precedente[v] = u;
                }
            }
        }

        // Step 3: check for negative-weight cycles.  The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        //  path, then there is a cycle.
        for (int j=0; j<E; ++j) {

            int u =        listaArestas.get(j).get(0).intValue();
            int v =        listaArestas.get(j).get(1).intValue();
            float peso = listaArestas.get(j).get(2);

            if (estimativa[u] != Integer.MAX_VALUE && estimativa[u]+peso < estimativa[v]){
                System.out.println("O grafo contem ciclo de peso negativo");
                return;
            }
        }
        printArr(precedente, estimativa, V, origem);
    }

    // A utility function used to print the solution
    private void printArr(int[] precedente, float[] dist, int V, int origem) {
        System.out.println(   "Vertices | Distancia da Origem | Precedente | Tamanho do Ciclo");
        for (int i=0; i<V; ++i){
            System.out.printf("    %d              %.2f             %d             %.2f\n ",
                                   i,             dist[i],    precedente[i], dist[i]+matrizAdjPeso.get(i).get(origem));

        }
    }
}
