//Zad2
import java.util.ArrayList;

/**
 * class to test Kruskal's algorithm to find MST
 */
public class KruskalAlg
{
    /**
     * weight of all edges in MST
     */
    private double weight;
    /**
     * ArrayList to contain all edges in MST
     */
    private ArrayList<Edge> mst = new ArrayList<>();
    /**
     * Queue to contain all edges in the graph
     */
    MinPriorityQueue<Edge> pq = new MinPriorityQueue<>();

    /**
     * getter of ArrayList to contain all edges in MST
     * @return
     */
    public ArrayList<Edge> getMst()
    {
        return mst;
    }

    /**
     * getter of weight of all edges in MST
     * @return
     */
    public double getWeight()
    {
        return  weight;
    }

    /**
     * constructor that do Kruskal's algorithm to find MST
     * @param G
     */
    public KruskalAlg(GraphWeighted G)
    {
        for (Edge e : G.edges())
        {
            pq.insert(e);
        }

        UF u = new UF(G.V());

        while (!pq.isEmpty() && mst.size() < G.V() - 1)
        {
            Edge e = pq.delMin();

            int v = e.either();
            int w = e.other(v);

            if (!u.union(v, w)) // check if vertices v and w are connected in one tree
            {

                mst.add(e);
                weight += e.weight();
            }
        }
    }


}
