//Zad1 //Zad3
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class to find vertex connected to edge with the smallest weight connecting vertex to MST
 * @param <Key>
 */
public class IndexMinPriorityQueue<Key extends  Comparable<Key>> implements Iterable<Integer>
{
    /**
     * size of the queue
     */
    private int maxN;

    /**
     * number of elements in the queue
     */
    private int n;

    /**
     * table to contain indexes
     */
    private int[] pq;

    /**
     * inverse qp[pq[i]] =  pq[qp[i]]=i
     */
    private int[] qp;

    /**
     * table to contain keys
     */
    private Key[] keys;

    /**
     * constructor
     * @param maxN size of the queue
     */
    public IndexMinPriorityQueue(int maxN)
    {
        if (maxN < 0) throw new IllegalArgumentException();

        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }

    /**
     * check if queue is empty
     * @return
     */
    public boolean isEmpty()
    {
        return n == 0;
    }

    /**
     * check if element is in the queue
     * @param i
     * @return
     */
    public boolean contains(int i)
    {
        validateIndex(i);
        return qp[i] != -1;
    }

    /**
     * method to get number of elements in the queue
     * @return number of elements in the queue
     */
    public int size()
    {
        return n;
    }

    /**
     * method to put elemet in the queue
     * @param i vertex connected to the lightest edge that connect given vertex to MST
     * @param key weight of the lightest edge that connect given vertex to MST
     */
    public void insert(int i, Key key)
    {
        validateIndex(i);
        if (contains(i)) throw new  IllegalArgumentException("Error! Index is in the queue");
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        moveUp(n);
    }

    /**
     * normalize heap
     * @param k
     */
    private void moveUp(int k)
    {
        while (k > 1 && greater(k/2, k))
        {
            swap(k, k/2);
            k = k/2;
        }
    }

    /**
     * chech if one element is greater than another (sort by weighted)
     * @param i
     * @param j
     * @return
     */
    private boolean greater(int i, int j)
    {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }


    /**
     * delete min element in the queue
     * @return vertex' number of min element
     */
    public int delMin()
    {
        if (n == 0) throw new NoSuchElementException("Blad:  Kolejka jest pusta");

        int min = pq[1];
        swap(1, n--);
        moveDown(1);
        qp[min] = -1;
        keys[min] = null;
        pq[n+1] = -1;


        return min;

    }

    /**
     * method which enable to decrease weight of the element in the queue
     * @param i
     * @param key
     */
    public void decreaseKey(int i, Key key)
    {
        validateIndex(i);
        if (!contains(i)) throw new  NoSuchElementException("Blad: indeksu nie ma w   kolejce!");


        if (keys[i].compareTo(key) == 0)   throw new IllegalArgumentException("Blad: klucz ma   taka sama wartosc jak wartosc zapisana w kolejce!");


        if (keys[i].compareTo(key) < 0)  throw new IllegalArgumentException("Blad: klucz jest   wiekszy niz wartosc zapisana w kolejce!");

        keys[i] = key;
        moveUp(qp[i]);
    }


    /**
     * check if vertex is in the queue
     * @param i
     */
    private void validateIndex(int i)
    {
        if (i < 0) throw new IllegalArgumentException("Blad:ujemny indeks: " + i);
        if (i >= maxN) throw new  IllegalArgumentException("Blad: wartosc spoza  zakresu: " + i);
    }


    /**
     * change elements in the heap
     * @param i one element
     * @param j another element
     */
    private void swap(int i, int j)
    {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }


    /**
     * normalize heap
     * @param k
     */
    private void moveDown(int k)
    {
        while (2*k <= n)
        {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            swap(k, j);
            k = j;
        }
    }


    public Key getKey(int index)
    {
        return keys[index];
    }

    /**
     *  method which enable iteration of all elements  in the queue
     * @return
     */
    public Iterator<Integer> iterator()
    {
        return new   PQIterator();
    }

    /**
     * private class which enable iteration of all elements  in the queue
     */
    private class PQIterator implements Iterator<Integer>
    {
        private IndexMinPriorityQueue<Key> copy;

        public PQIterator()
        {
            copy = new IndexMinPriorityQueue<Key>(pq.length - 1);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i], keys[pq[i]]);
        }

        public boolean hasNext()
        {
            return !copy.isEmpty();
        }

        public void remove() {}

        public Integer next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }

}
