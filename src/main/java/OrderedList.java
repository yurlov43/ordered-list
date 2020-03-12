import java.util.*;


public class OrderedList<T extends Comparable<T>> {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        if (v1.compareTo(v2) < 0) {
            return -1;
        }
        if (v1.compareTo(v2) > 0) {
            return 1;
        }
        return 0;
    }

    public void add(T value) {
        Node<T> node = this.head;
        if (head == null) {
            node = new Node<>(value);
            head = node;
            tail = node;
        } else {
            while (node != null) {
                int comparisonResult = compare(node.value, value);
                if (comparisonResult == 0) {
                    insertAfter(node, new Node<>(value));
                    break;
                }
                if (comparisonResult == (_ascending ? 1 : -1)) {
                    insertAfter(node.prev, new Node<>(value));
                    break;
                }
                if (comparisonResult == (_ascending ? -1 : 1) && node == tail) {
                    insertAfter(tail, new Node<>(value));
                    break;
                }
                node = node.next;
            }
        }
    }

    public void insertAfter(Node<T> node, Node<T> nodeToInsert) {
        if (node == null) {
            nodeToInsert.next = head;
            head.prev = nodeToInsert;
            this.head = nodeToInsert;
        } else {
            nodeToInsert.next = node.next;
            if (node.next == null) {
                this.tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }
            node.next = nodeToInsert;
            nodeToInsert.prev = node;
        }
    }

    public Node<T> find(T val) {
        Node<T> node = this.head;

        while (node != null && compare(node.value, val) != (_ascending ? 1 : -1)) {
            if (compare(node.value, val) == 0)
                return node;
            node = node.next;
        }
        return null;
    }

    public void delete(T val) {
        Node<T> node = find(val);

        if (node != null) {
            deleteNode(node);
        }
    }

    public void deleteNode(Node<T> node) {
        if (node == this.head) {
            if (node.next == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = node.next;
                this.head.prev = null;
            }
        } else {
            if (node.next == null) {
                this.tail = node.prev;
                this.tail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node<T> node = this.head;
        int length = 0;

        while (node != null) {
            length = length + 1;
            node = node.next;
        }
        return length;
    }

    ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> arrayList = new ArrayList<Node<T>>();
        Node<T> node = head;

        while(node != null)
        {
            arrayList.add(node);
            node = node.next;
        }
        return arrayList;
    }
}

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}