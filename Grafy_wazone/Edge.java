//Zad1 //Zad2
/**
 * class that represents edge in Weighted graph
 */
public class Edge implements Comparable
{

    /**
     * one vertix
     */
    private final int v;

    /**
     * another vertix
     */
    private final int w;

    /**
     * weight (lenght) of the edge
     */
    private final double weight;

    /**
     * constructor
     * @param v virst vertex
     * @param w second vertex
     * @param weight weight (length) of the edge
     */
    public Edge(int v, int w, double weight)
    {
        if (v < 0) throw new IllegalArgumentException("Error! Number can't be less than zero.");

        if (w < 0) throw new IllegalArgumentException("Error! Number can't be less than zero.");

        if (Double.isNaN(weight)) throw new IllegalArgumentException("Error! This isn't a number.");

        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * getter of weight
     * @return
     */
    public double weight() { return weight; }

    /**
     * get first of vertex
     * @return
     */
    public int either() { return v; }

    /**
     * get another vertex (to given one)
     * @param vertex
     * @return
     */
    public int other(int vertex)
    {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("Error! vertex is not part of the edge");
    }

    @Override
    public String toString()
    {
        return String.format("%d-%d %.2f", v, w, weight);
    }

    @Override
    public int compareTo(Object o) {
        Edge e = (Edge) o;
        return Double.compare(this.weight, e.weight);
    }
}