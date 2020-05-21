//Zad2
import java.util.NoSuchElementException;

/**
 * class to find edge with the smallest weight
 * @param <Key>
 */
public class MinPriorityQueue<Key>
{
    /**
     * table to contain weights (index are from 1 to n)
     */
    private Key[] pqueue;

    /**
     * number of elements in the queue
     */
    private int n;

    /**
     * constructor
     * @param size size of the queue
     */
    public MinPriorityQueue(int size)
    {
        pqueue = (Key[]) new Object[size + 1];
        n = 0;
    }

    /**
     * constructor, creating queue of size 1
     */
    public MinPriorityQueue()
    {
        this(1);
    }

    /**
     * constructor to create queue, with given table of keys (weights)
     * @param keys
     */
    public MinPriorityQueue(Key[] keys)
    {
        n = keys.length;
        pqueue = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pqueue[i+1] = keys[i];
        for (int k = n/2; k >= 1; k--)
            moveDown(k);
    }

    /**
     * check if queue is emptyy
     * @return
     */
    public boolean isEmpty() { return n == 0; }

    /**
     * method to check the size of the queue
     * @return
     */
    public int size() { return n; }

    /**
     * method to put key (weight) in the queue
     * @param key
     */
    public void insert(Key key)
    {
        pqueue[++n] = key;
        moveUp(n);
        if (n == pqueue.length - 1)  resize(2 *pqueue.length);
    }

    /**
     * delete min edge with the smallest weight
     * @return edge with the smallest weight
     */
    public Key delMin() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        Key min = pqueue[1];
        swap(1, n--);
        moveDown(1);
        pqueue[n+1] = null;
        if ((n > 0) && (n == (pqueue.length - 1) / 4))
            resize(pqueue.length / 2);
        return min;
    }

    /**
     * method to normalize heap
     * @param k
     */
    private void moveUp(int k) {
        while (k > 1 && greater(k/2, k)) {
            swap(k, k/2);
            k = k/2;
        }
    }

    /**
     * method to normalize heap
     * @param k
     */
    private void moveDown(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    /**
     *
     * @return min key in the queue
     */
    public Key min() {
        if (isEmpty()) throw new
                NoSuchElementException("Queue is empty");
        return pqueue[1];
    }

    /**
     * check if weight of one element is bigger than another
     * @param i first element
     * @param j second element
     * @return
     */
    private boolean greater(int i, int j) {
        return ((Comparable<Key>) pqueue[i]).compareTo(pqueue[j]) > 0;

    }

    /**
     * method to swap to element in the queue
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Key tmp = pqueue[i];
        pqueue[i] = pqueue[j];
        pqueue[j] = tmp;
    }


    /**
     * resize size of the queue
     * @param size
     */
    private void resize(int size) {
        Key[] temp = (Key[]) new Object[size];
        for (int i = 0; i <= n; i++)
            temp[i] = pqueue[i];
        pqueue = temp;
    }
}