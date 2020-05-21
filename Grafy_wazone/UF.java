//Zad2
import java.util.stream.IntStream;

/**
 * class to connect vertices of the graph avoiding creating cycles
 *
 */
public class UF
{
    /**
     * number of subnets
     */
    private int count;

    /**
     * table to contain IDs of subnets
     */
    private int[] subNets;

    /**
     * table to contain number of elements in given subnet
     */
    private int[] subNetsSizes;

    /**
     *constructor
     * @param max number of vertices in the graph
     */
    public UF(int max)
    {
        count = max;
        subNets = new int[max];
        subNetsSizes = new int[max];
        for (int i = 0; i < max; i++)
        {
            subNets[i] = i;
            subNetsSizes[i] = 1;
        }
    }

    /**
     *
     * @param p element of given subnet
     * @return ID of subnet of given subnet
     */
    public int find(int p)
    {
        while (p != subNets[p])
        {
            p = subNets[p];

        }
        return p;
    }


    /**
     *
     * @return number of subnets
     */
    public int getCount()
    {
        return count;
    }


    /**
     * make connection of two vertices
     * @param p first vertex to connect
     * @param q dsecond vertex to connect
     * @return <code>true</code> when vertices are in one subnet
     */
    public boolean union(int p, int q)
    {
        int i = find(p);
        int j = find(q);
        if (i == j)
        {
            return true; //two vertices are in one subnet
        }

        if (subNetsSizes[i] < subNetsSizes[j])
        {
            subNets[i] = j;
            subNetsSizes[j] += subNetsSizes[i];
        }
        else
        {
            subNets[j] = i;
            subNetsSizes[i] += subNetsSizes[j];
        }
        count--;
        return false;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer("UF {count=");
        sb.append(count).append(" subNets=[");
        IntStream.of(subNets).forEach(e -> sb.append(e).append(", "));
        sb.delete(sb.length() - ", ".length(), sb.length());
        sb.append("] subNetsSizes=[");
        IntStream.of(subNetsSizes).forEach(e -> sb.append(e).append(", "));
        sb.delete(sb.length() - ", ".length(), sb.length());
        sb.append("]}");
        return sb.toString();
    }





}