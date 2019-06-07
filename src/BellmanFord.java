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
    public void bellmanford(int src) {
        int V = matrizAdjPeso.size(), E = listaArestas.size();
        float dist[] = new float[V];

        // Step 1: Initialize distances from src to all other
        // vertices as INFINITE
        for (int i=0; i<V; ++i) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for (int i=1; i<V; ++i) {
            for (int j=0; j<E; ++j) {
                int u =        listaArestas.get(j).get(0).intValue();
                int v =        listaArestas.get(j).get(1).intValue();
                float weight = listaArestas.get(j).get(2);
                if (dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]){
                    dist[v]=dist[u]+weight;
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
            float weight = listaArestas.get(j).get(2);

            if (dist[u] != Integer.MAX_VALUE &&
                    dist[u]+weight < dist[v])
                System.out.println("Graph contains negative weight cycle");
        }
        printArr(dist, V);
    }

    // A utility function used to print the solution
    void printArr(float dist[], int V)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i=0; i<V; ++i)
            System.out.println(i+"\t\t"+dist[i]);
    }
}
