public class MyLinkedQueue<T> {
    private MyLinkedList<T> lq = new MyLinkedList<>();

    public int size() {
        return lq.size();
    }

    public boolean isEmpty() {
        return lq.isEmpty();
    }

    public void insert(T o) {
        lq.insertFirst(o);
    }

    public T remove() {
        return lq.removeLast();
    }

    public void push(T o) {
        lq.insertFirst(o);
    }

    public T pop() {
        return lq.removeLast();
    }
    public T peek() {
        return lq.getLast();
    }
}
