import java.util.NoSuchElementException;

public class MyQueue<T> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    //0 1 2 3 4
    //b
    //  e
    //8


    public MyQueue(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Object[capacity];
    }

    /**
     * Метод добавления в очередь нового элемента
     *
     * @param item добавляемый элемент
     * @throws IllegalStateException если очередь полная
     */
    public void insert(T item) throws IllegalStateException {
        if (isFull()) {
            expandCapacity();
//            throw new IllegalStateException("Очередь заполнена");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    public T remove() {
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }


    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private void expandCapacity() {
        capacity += DEFAULT_CAPACITY;
        T[] newList = (T[]) new Comparable[capacity];
        System.arraycopy(list, begin, newList, 0, size - begin);
        if (begin > 0) System.arraycopy(list, 0, newList, size - begin, begin);
        begin = 0;
        end = size;
        list = newList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        int i = begin;
        if (size > 0) {
            do {
                sb.append(list[i]).append(", ");
                i = nextIndex(i);
            } while (i != end);
            sb.setLength(sb.length() - 2);
        }
        sb.append(" ]");
        return sb.toString();
    }
}
