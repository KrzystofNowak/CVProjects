//Zad2
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * class to test Kruskal's algorithm to find MST
 */
public class KruskalAlgTest
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("duzy_graf.txt"));
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

        //calling Kruskal's algorithm
        KruskalAlg ka = new KruskalAlg(G);
        //print all edges in MST
        for (Edge e :ka.getMst())
        {
            System.out.println(e);
        }
        //print sum og weights of all edges in MST
        System.out.println(ka.getWeight());

    }

}
