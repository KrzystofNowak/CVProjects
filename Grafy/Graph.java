package com.company;
import java.util.ArrayList;

/**
 * class which represents graph
 */
public class Graph {

    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;

    /**
     * constructor of this class
     * @param V
     */
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Error! number can't be less than 0");
        this.V = V;
        this.E = 0;

        adj = (ArrayList<Integer>[]) new ArrayList[V];

        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }


    /**
     *
     * @return number of vertex
     */
    public int V() {
        return V;
    }

    /**
     *
     * @return number of edges
     */
    public int E() {
        return E;
    }


    /**
     * check if given vertex has proper number (in range from 0 to V-1)
     * @param v
     */
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Inappropriate vertex!");
    }


    /**
     * add edge in graph
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     *
     * @param v
     * @return arraylist with vertex connected to given vertex
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     *
     * @param v
     * @return the degrre of given vertex
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     *
     * @return maximum degree of vertex in this graph
     */
    public int maxDegree() {
        int max = 0;
        for(int v = 0; v < V(); v++)
            if(degree(v) > max)
                max = degree(v);
        return max;
    }

    /**
     *
     * @return average degree of vertex in this graph
     */
    public int avgDegree(){
        return 2 * E() / V() ;
    }

    /**
     * method which enable printing this graph
     * @return
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + "vertexes, " + E + " edges " + "\n");

        for (int v = 0; v < V; v++) {

            s.append(v + ": ");

            for (int w : adj[v]) {
                s.append(w + " ");
        }

            s.append("\n");
        }

        return s.toString();
    }
}