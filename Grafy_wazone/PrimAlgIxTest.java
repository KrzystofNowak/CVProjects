//Zad1
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * class to test Prim's algorithm to find MST
 */
public class PrimAlgIxTest
{

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("maly_graf.txt"));
        String text;
        int E = 0;
        GraphWeighted G = null;
        //creating graph
            text = scanner.nextLine();
            int V = Integer.parseInt(text);
            G = new GraphWeighted(V);

            text = scanner.nextLine();
            E = Integer.parseInt(text);


        for(int i = 0; i < E; i++)
        {
            text = scanner.nextLine();
            String[] edge = text.split(" ");

            G.addEdge(new Edge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]), Double.parseDouble(edge[2])));
        }

        //calling Prim's algorithm
       PrimAlgIx pai = new PrimAlgIx(G);

        for (Edge e :pai.getEdges())
        {
            System.out.println(e);
        }

        //print sum og weights of all edges in MST
        System.out.println(pai.getWeight());

    }
}
