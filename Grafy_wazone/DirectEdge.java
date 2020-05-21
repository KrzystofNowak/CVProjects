//Zad3

/**
 * class that represents direct edge in directed weighted graph
 */
public class DirectEdge
{
    private final int v;
    private final int w;
    private final int  weight;
    public DirectEdge(int v, int w, int  weight)
    {
        if (v < 0) throw new IllegalArgumentException("Blad! liczba nie moze byc ujemna.");

        if (w < 0) throw new IllegalArgumentException("Blad! liczba nie moze byc ujemna.");

        if (Double.isNaN(weight)) throw new   IllegalArgumentException("Blad! to nie jest liczba.");

        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from()
    {
        return v;
    }

    public int to()
    {
        return w;
    }

    public int weight()
    {
        return weight;
    }

    public String toString()
    {
        return v + "->" + w + " " + weight;

    }


}
