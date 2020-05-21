import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMinPriorityQueue<Key> implements Iterable<Key> {
    private Key[] pqueue; //tablica przechowuje klucze(elementy) nieuporzadkowane

    private int n = 0; //liczba elementow w kolejce

    public SimpleMinPriorityQueue(int size) {
        pqueue = (Key[]) new Object[size];
        n = 0;
    }

    public SimpleMinPriorityQueue() {
        this(1);
    }

    public SimpleMinPriorityQueue(Key[] keys) {
        n = keys.length;
        pqueue = (Key[]) new Object[keys.length];
        for (int i = 0; i < n; i++)
            pqueue[i] = keys[i];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(Key key) {
        if (n == pqueue.length) resize(2 * pqueue.length);
        pqueue[n++] = key;
    }

    private void resize(int size) {
        Key[] temp = (Key[]) new Object[size];
        for (int i = 0; i <= n; i++)
            temp[i] = pqueue[i];
        pqueue = temp;
    }

    public Key delMin() {
        if (isEmpty()) throw new
                NoSuchElementException("Kolejka jest pusta");
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (!greater(i, minIndex))
                minIndex = i;
        }
        swap(minIndex, n - 1);
        Key min = pqueue[--n];
        pqueue[n] = null; //porzadkowanie tablicy
        if ((n > 0) && (n == (pqueue.length - 1) / 4))
            resize(pqueue.length / 2);
        return min;
    }

    private boolean greater(int i, int j) {
        return ((Comparable<Key>)
                pqueue[i]).compareTo(pqueue[j]) > 0;
    }

    private void swap(int i, int j) {
        Key tmp = pqueue[i];
        pqueue[i] = pqueue[j];
        pqueue[j] = tmp;
    }

    public Key min() {
        if (isEmpty()) throw new
                NoSuchElementException("Kolejka jest pusta");
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (!greater(i, minIndex))
                minIndex = i;
        }
        return pqueue[minIndex];
    }

    public Iterator<Key> iterator() {
        return new SimpleMinPriorityQueue.QueueIterator();
    }

    private class QueueIterator implements Iterator<Key> {
        private int i = n; //dostępn do zmiennych klasyzewnętrznej

        public boolean hasNext() {
            return i > 0;
        }

        public Key next() {
            return pqueue[--i];
        }

        public void remove() {
        } //bezimplementacji

    }
}
