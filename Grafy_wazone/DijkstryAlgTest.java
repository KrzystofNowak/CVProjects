//Zad3
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * class to test Dijkstry Algorithm
 */
public class DijkstryAlgTest
{

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("maly_graf2.txt"));
        String text;
        int E = 0;
        DigraphWeighted G = null;
        //creating graph
        text = scanner.nextLine();
        int V = Integer.parseInt(text);
        G = new DigraphWeighted(V);

        text = scanner.nextLine();
        E = Integer.parseInt(text);


        for(int i = 0; i < E; i++)
        {
            text = scanner.nextLine();
            String[] edge = text.split(" ");

            G.addEdge(new DirectEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]), Integer.parseInt(edge[2])));
        }

        System.out.println(G);
        //calling Dijkstry algorithm
       DijkstryAlg da= new DijkstryAlg(G,0);


       PrintWriter printWriter = new PrintWriter("wynik.txt");

       Random random= new Random();
       printWriter.println(da.pathTo(random.nextInt(G.V())));
       printWriter.println(da.getTab());
       printWriter.close();
    }
}
