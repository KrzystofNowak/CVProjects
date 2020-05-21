import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * class that do Dijkstry's algorithm
 */
public class DijkstryAlg {

    private int [] distTo;
    private DirectEdge[] edgeTo;
    private IndexMinPriorityQueue<Integer> pq;

    private int tab[][];

    public String getTab()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < edgeTo.length; i++){
            sb.append(i + ": ");
            for(int j = 0; j < edgeTo.length; j++)
                sb.append(tab[i][j]).append(" ");
            sb.append("\n");
        }

        return sb.toString();
    }

    public DirectEdge getEdgeTo(int index) {
        return edgeTo[index];
    }



    public DijkstryAlg(DigraphWeighted G, int s) {
        for (DirectEdge e : G.edges()) {
            if (e.weight() < 0)  throw new IllegalArgumentException("waga krawedzi nie moze byc ujemna");

        }
        distTo = new int [G.V()];
        edgeTo = new DirectEdge[G.V()];

        validateVertex(s);

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = (int)Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0;
        pq = new IndexMinPriorityQueue<>(G.V());
        pq.insert(s, distTo[s]);

        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectEdge e : G.adj(v))
                relax(e);
        }
    }



    private void relax(DirectEdge e) {
        int v = e.from();
        int w = e.to();

        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;

            if (pq.contains(w)) {
                pq.decreaseKey(w, distTo[w]);
                printStructures();
            }

            else {
                pq.insert(w, distTo[w]);
                printStructures();
            }

        }
    }


    private void validateVertex(int v) {
        int V = distTo.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Blad! wierzcholek nie nalezy do grafu.");
    }


    public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }


    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < (int)Double.POSITIVE_INFINITY;
    }


    public Iterable<DirectEdge> pathTo(int v) throws FileNotFoundException {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        ArrayList<DirectEdge> path = new  ArrayList<>();

        tab = new int[edgeTo.length][edgeTo.length];

        for (DirectEdge e = edgeTo[v]; e != null; e =  edgeTo[e.from()]) {
            path.add(e);
            tab[e.from()][e.to()] = e.weight();

        }

        return path;
    }


    public void printStructures() {
        StringBuffer sb = new StringBuffer("Structures=: ");
        sb.append("\n");
        sb.append("EdgeTo: ");
        sb.append("\n");

        for(int i=0; i<edgeTo.length; i++) {
            sb.append(i +": ").append(edgeTo[i]);
            sb.append("\n");
        }

        sb.append("\n");
        sb.append("DistTo: ");
        sb.append("\n");
        IntStream.of(distTo).forEach(e -> sb.append(e).append(", ").append("\n"));
        sb.delete(sb.length() - ", ".length(), sb.length());
        sb.append("\n");
        sb.append("\n");
        sb.append("pq:");
        sb.append("\n");

        for( int i: pq ) {
            sb.append(i).append(" ").append(pq.getKey(i));
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}