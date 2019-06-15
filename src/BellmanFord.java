import java.util.LinkedList;

public class BellmanFord {

    private LinkedList<LinkedList<Float>> matrizAdjPeso;
    private LinkedList<LinkedList<Float>> listaArestas;

    public BellmanFord(MatrizAdjPeso matrizAdjPeso){
        this.listaArestas = matrizAdjPeso.getListaArestas();
        this.matrizAdjPeso = matrizAdjPeso.getMatrizAdjPeso();
    }

    public void bellmanford(int origem) {

        int V = matrizAdjPeso.size(); //Quantidade de vertices
        int E = listaArestas.size(); //Quantidade de arestas

        float[] estimativa = new float[V];
        int[] precedente = new int[V];

        //Inicializa a disntancia da origem para os outros vertices como infinito;
        for (int i=0; i<V; ++i) {
            estimativa[i] = Integer.MAX_VALUE;
        }
        estimativa[origem] = 0; //Distancia da origem para ele mesmo é zero


        //Relaxar todas as arestas V-1 vezes (V = quantidade de vertices).
        //Um caminho simples da origem para outro vertice pode ter njo maximo V - 1 arestas
        for (int i=1; i<V; ++i) {
            for (int j=0; j<E; ++j) {
                int u =      listaArestas.get(j).get(0).intValue(); //vertice de origem da aresta
                int v =      listaArestas.get(j).get(1).intValue(); //vertice de destino
                float peso = listaArestas.get(j).get(2);            //peso da aresta

                if (estimativa[u] != Integer.MAX_VALUE && estimativa[u] + peso < estimativa[v]){
                    estimativa[v] = estimativa[u] + peso;
                    precedente[v] = u;
                }
            }
        }

        //Verifica se há ciclos negativos
        for (int j=0; j<E; ++j) {

            int u =      listaArestas.get(j).get(0).intValue();
            int v =      listaArestas.get(j).get(1).intValue();
            float peso = listaArestas.get(j).get(2);

            if (estimativa[u] != Integer.MAX_VALUE && estimativa[u]+peso < estimativa[v]){
                System.out.println("O grafo contem ciclo de peso negativo");
                return;
            }
        }

        printArr(precedente, estimativa, V, origem);
    }

    private void printArr(int[] precedente, float[] dist, int V, int origem) {
        System.out.println(   "Vertices | Distancia da Origem | Precedente | Tamanho do Ciclo");
        for (int i=0; i<V; ++i){
            System.out.printf("    %d              %.2f             %d             %.2f\n ",
                                   i,             dist[i],    precedente[i], dist[i]+matrizAdjPeso.get(i).get(origem));

        }
    }
}
