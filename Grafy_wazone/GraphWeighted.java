//Zad1 //Zad2

/**
 * class to represent weighted graph
 */

import java.util.ArrayList;

/**
 * class that represents weighted graph
 */
public class GraphWeighted
{
    /**
     * number of vertices
     */
    private final int V;
    /**
     * number of edges
     */
    private int E;

    /**
     * Table of ArrayLists. Each ArrayList contain all edges connected to given vertex. Given vertex is index in the table
     */
    private ArrayList<Edge>[] adj;

    /**
     * constructor
     * @param V number of vertices in weighted graph
     */
    public GraphWeighted(int V)
    {
        if (V < 0) throw new IllegalArgumentException("Error! Number can't be less than zero");
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Edge>[]) new ArrayList[V];

        for (int v = 0; v < V; v++)
        {
            adj[v] = new ArrayList<Edge>();
        }
    }

    /**
     * getter of number of vertices
     * @return
     */
    public int V() { return V; }

    /**
     * getter of number of edges
     * @return
     */
    public int E() { return E; }

    /**
     * check if given vertex is in the graph
     * @param v given vertex
     */
    private void validVertex(int v)
    {
        if (v < 0 || v >= V) throw new IllegalArgumentException("Error! vertex is not a part of the graph");
    }

    /**
     * method to add edge to graph
     * @param e edge to add to the graph
     */
    public void addEdge(Edge e)
    {
        int v = e.either();
        int w = e.other(v);
        validVertex(v);
        validVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }


    /**
     * method which enable iteration of all edges connected to given vertex
     * @param v given vertex
     * @return
     */
    public Iterable<Edge> adj(int v)
    {
        validVertex(v);
        return adj[v];
    }

    /**
     * method which enable iteration of all edges in the graph
     * @return
     */
    public Iterable<Edge> edges()
    {
        ArrayList<Edge> list = new  ArrayList<>();

        for (int v = 0; v < V; v++)
        {
            for (Edge e : adj(v))
            {
                if (e.other(v) > v)
                {
                    list.add(e);
                }
            }
        }
        return list;
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();

        s.append(V + " " + E + "\n");

        for (int v = 0; v < V; v++)
        {
            s.append(v + ": ");

            for (Edge e : adj[v])
            {
                s.append(e + " ");
            }
            s.append("\n");
        }

        return s.toString();
    }


}