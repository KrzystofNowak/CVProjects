import java.util.ArrayList;


public class PrimAlg
{

    private double weight;

    private ArrayList<Edge> mst;

    private boolean[] marked; // marked[v] - wierzcholek w MST
    private MinPriorityQueue<Edge> pq; // krawedzie  przekroju, dla wierzcholkow w drzewie


    public PrimAlg(GraphWeighted G)
    {
        mst = new ArrayList<Edge>();
        pq = new MinPriorityQueue<Edge>();
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++)
        {
            if (!marked[v]) //alg. dla lasu MST
                prim(G, v);
        }
    }


    private void prim(GraphWeighted G, int s)
    {
        scan(G, s); //skanowanie wierzcholka zrodlowego

        while (!pq.isEmpty())
        {
            Edge e = pq.delMin(); //najlzejsza krawedz
            int v = e.either();
            int w = e.other(v);

            if (marked[v] && marked[w])
                continue; // obwa wierzcholki krawedzi  przeskanowane

            mst.add(e); //dodanie krawedzi do MST
            weight += e.weight();
            if (!marked[v]) scan(G, v); //przeskanowanie v
            if (!marked[w]) scan(G, w); //przeskanowanie w
        }
    }

    //dodanie wszystkich krawedzi wychodzacych z v  prowadzacych do wierzolkow nieprzeskanownaych

    private void scan(GraphWeighted G, int v)
    {
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)]) pq.insert(e);
    }



    public Iterable<Edge> edges()
    {
        return mst;
    }


    public double weight()
    {
        return weight;
    }





}
