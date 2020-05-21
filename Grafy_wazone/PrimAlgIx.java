//Zad1
import java.util.ArrayList;

/**
 * class to test Prim's algorithm to find MST
 */
public class PrimAlgIx
{
    /**
     * table to contain the lightest edge that connect given vertex to MST. given vertex is a number in the table
     */
    private Edge[] edgeTo;

    /**
     * table to contain the weight of the lightest edge that connect given vertex to MST. given vertex is a number in the table
     */
    private double[] distTo;

    /**
     * indexPriorityQueue  to find vertex connected to edge with the smallest weight connecting vertex to MST
     */
    private IndexMinPriorityQueue<Double> pq;

    /**
     * ArrayList to contain all edges in MST
     */
    private ArrayList<Edge> edges;

    /**
     * weight of all edges in MST
     */
    private double weight;

    /**
     * getter of ArrayList to contain all edges in MST
     * @return
     */
    public ArrayList<Edge> getEdges()
    {
        return edges;
    }

    /**
     * getter of weight of all edges in MST
     * @return
     */
    public double getWeight()
    {
        return weight;
    }


    /**
     * constructor which calls Prim's algorithm to find MST
     * @param G given graph
     */
    public PrimAlgIx(GraphWeighted G)
    {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPriorityQueue<Double>(G.V());
        edges = new ArrayList<>();

        weight =0.0;

        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        for (int v = 0; v < G.V(); v++)
            if (distTo[v]==Double.POSITIVE_INFINITY)
                prim(G, v);
    }


    /**
     * Prim's algorithm to find MST
     * @param G given graph
     * @param s forst vertex
     */
    private void prim(GraphWeighted G, int s)
    {
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty())
        {
            int v = pq.delMin();
            edges.add(edgeTo[v]); // enable printing MST
            weight+=distTo[v]; // change weight
            scan(G, v);
        }
    }

    /**
     * method put elements in indexPriorityQueue
     * @param G given graph
     * @param v given vertex
     */
    private void scan(GraphWeighted G, int v)
    {
       distTo[v] = 0.0; //vertex v is in the MST

        for (Edge e : G.adj(v))
        {
            int w = e.other(v);

            if (distTo[w]==0.0) continue; //vertex w is in the MST

            if (e.weight() < distTo[w])
            {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w))
                    pq.decreaseKey(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
            }
        }
   }


}
