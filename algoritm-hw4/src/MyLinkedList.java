import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private Node first;
    private Node last;

    private int size;

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    public ListIterator<T> listIterator() {
        return new ListIter();
    }

    private class Iter implements Iterator<T> {
        Node current = new Node(null, first);
        Node prevNode;
        int nextIndex;

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            prevNode = current;
            current = current.getNext();
            nextIndex++;
            return current.getValue();
        }
    }

    private class ListIter extends Iter implements ListIterator<T> {

        @Override
        public boolean hasPrevious() {
            return current.getPrev() != null;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            prevNode = current;
            current = current.getPrev();
            nextIndex--;
            return current.getValue();
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        //удаляет элемент который прошли методом next или prev
        @Override
        public void remove() {
            if (prevNode == null)
                throw new IllegalStateException();
            if (prevNode.getNext() == current.getPrev()) {
                current.getNext().setPrev(prevNode.getPrev());
                if (prevNode.getNext() != null) {
                    prevNode.getPrev().setNext(current.getNext());
                }
                nextIndex--;
            }
            if (current.getNext() == prevNode.getPrev()) {
                current.getPrev().setNext(prevNode.getNext());
                if (prevNode.getNext() != null) {
                    prevNode.getNext().setPrev(current.getNext());
                }
            }
            prevNode = null;
            size--;
        }

        //заменяет элемент который прошли методом next или prev
        @Override
        public void set(T t) {
            if (prevNode == null)
                throw new IllegalStateException();
            if (prevNode.getNext() == current.getPrev()) {
                current.getPrev().setValue(t);
            }
            if (current.getNext() == prevNode.getPrev()) {
                current.getNext().setValue(t);
            }
        }

        //        Вставляет указанный элемент в список (необязательная операция). Элемент вставляется непосредственно перед
//        элементом, который будет возвращен next, если таковой имеется, и после элемента, который будет возвращен
//        previous, если таковой имеется. (Если список не содержит элементов, новый элемент становится единственным
//        элементом в списке.)
//        Новый элемент вставляется перед неявным курсором: последующий вызов next не будет затронут, а последующий
//        вызов previous вернет новый элемент. ((Этот вызов увеличивает на единицу значение, которое будет возвращено
//        вызовом следующего индекса или предыдущего индекса.)
        @Override
        public void add(T t) {
            if (nextIndex == 0) {
                insertFirst(t);
                current.setPrev(first);
            } else if (nextIndex == size) {
                insertLast(t);
                current.setPrev(last);
            } else {
                Node newNode = new Node(t);
                newNode.setNext(current.getNext());
                newNode.setPrev(current.getPrev());
                current.setPrev(newNode);
            }
            nextIndex++;
            size++;
        }
    }

    private class Node {
        Node prev;
        T value;
        Node next;

        public Node(Node prev, T value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public void insertFirst(T item) {
        Node newNode = new Node(item, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public T removeFirst() {
        T temp = getFirst();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return temp;
    }

    public void insertLast(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.setPrev(last);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public T removeLast() {
        T temp = getLast();
        if (last.getPrev() == null) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        size--;
        return temp;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        return first.value;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        return last.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public final int indexOf(T item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value.equals(item)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new IllegalStateException("index: " + index);
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        if (index == size) {
            insertLast(item);
            return;
        }

        Node current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.getNext();
            i++;
        }
        Node newNode = new Node(current, item, current.getNext());
        current.getNext().setPrev(newNode);
        current.setNext(newNode);
        size++;
    }

    public boolean remove(T item) {
        if (isEmpty()) {
            return false;
        }
        if (first.value.equals(item)) {
            removeFirst();
            return true;
        }

        Node current = first;
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            removeLast();
            return true;
        }

        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = first;
        while (current != null) {
            sb.append(current.value).append(", ");
            current = current.getNext();
        }
        if (!isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}
