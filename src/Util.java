import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author mathe
 */
public class Util {
    
    private LinkedList<LinkedList<Float>> listaArestas = new LinkedList<>();
    private int maiorVertice = 0;


    public static void pausa(){
        System.out.println("Aperte 'Enter' para continuar...");
        try{
            System.in.read();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
    
    public boolean initDado(){
        Scanner scanner;
        try {
            System.out.print("Nome do arquivo: ");
            scanner = new Scanner(System.in);
            String nomeArquivo = scanner.nextLine();
            scanner = new Scanner(new File("dados/"+ nomeArquivo + ".txt"));
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());
            return false;
        }

        listaArestas = new LinkedList<>();


        for(int index = 0; scanner.hasNext(); index++){
            listaArestas.add(new LinkedList<>());

            int origem = scanner.nextInt();
            listaArestas.get(index).add((float) origem);
            if (origem > maiorVertice) maiorVertice = origem;

            int destino = scanner.nextInt();
            listaArestas.get(index).add((float) destino);
            if (destino > maiorVertice) maiorVertice = destino;

            float peso = scanner.nextFloat();
            listaArestas.get(index).add((float) (Math.log10(peso) * -1));
        }

        return true;
    }
    
    public LinkedList<LinkedList<Float>> getListaArestas(){
        return listaArestas;
    }

    public int getQuantidadeVertices(){
        return (maiorVertice + 1);
    }
    
}
