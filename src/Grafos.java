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
        util.initDado();
        MatrizAdjPeso matrizAdjPeso = new MatrizAdjPeso(util.getListaElementos());

        matrizAdjPeso.showMatriz();

        Dijkstra dijkstra = new Dijkstra(matrizAdjPeso.getMatrizAdjPeso());
        dijkstra.dijkstra(1);

    }
}

