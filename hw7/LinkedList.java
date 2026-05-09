// javac -Xlint:all,-overrides -Werror LinkedList.java

public class LinkedList<E>
{
    private class Node<E>
    {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next)
        {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public LinkedList()
    {
        head = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public void clear()
    {
        head = null;
        size = 0;
    }

    public void add(int idx, E data)
    {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException(String.format("Index out of bounds: %d", idx));
        }
        else if (idx == 0) {
            head = new Node<E>(data, head);
        }
        else {
            Node<E> prev = head;
            for (int i = 0; i < idx - 1; ++i) {
                prev = prev.next;
            }
            prev.next = new Node<E>(data, prev.next);
        }
        size += 1;
    }

    public void add(E data)
    {
        add(size, data);
    }

    public boolean contains(Object o)
    {
        Node<E> curr = head;
        while (curr != null) {
            if (areEqual(curr.data, o)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public E get(int idx)
    {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException(String.format("Index out of bounds: %d", idx));
        }
        else {
            Node<E> curr = head;
            for (int i = 0; i < idx; ++i) {
                curr = curr.next;
            }
            return curr.data;
        }
    }

    public int indexOf(Object o)
    {
        int idx = -1;
        int curr_idx = 0;
        Node<E> curr = head;
        while (curr != null) {
            if (areEqual(curr.data, o)) {
                idx = curr_idx;
                break;
            }
            curr = curr.next;
            curr_idx += 1;
        }
        return idx;
    }

    public E remove(int idx)
    {
        E res = null;
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException(String.format("Index out of bounds: %d", idx));
        }
        else if (idx == 0) {
            res = head.data;
            head = head.next;
        }
        else {
            Node<E> prev = head;
            for (int i = 0; i < idx - 1; ++i) {
                prev = prev.next;
            }
            res = prev.next.data;
            prev.next = prev.next.next;
        }
        size -= 1;
        return res;
    }

    public boolean remove(Object o)
    {
        if (isEmpty()) {
            return false;
        }
        else if (areEqual(head.data, o)) {
            remove(0);
            return true;
        }
        else {
            Node<E> prev = head;
            while (prev.next != null) {
                if (areEqual(prev.next.data, o)) {
                    prev.next = prev.next.next;
                    size -= 1;
                    return true;
                }
                prev = prev.next;
            }
            return false;
        }
    }

    public E set(int idx, E data)
    {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException(String.format("Index out of bounds: %d", idx));
        }
        Node<E> curr = head;
        for (int i = 0; i < idx; ++i) {
            curr = curr.next;
        }
        E oldData = curr.data;
        curr.data = data;
        return oldData;
    }

    public String toString()
    {
        String msg = "[";
        Node<E> curr = head;
        while (curr != null) {
            msg += curr.data;
            if (curr.next != null) {
                msg += ", ";
            }
            curr = curr.next;
        }
        msg += "]";
        return msg;
    }

    public boolean equals(Object o)
    {
        if (!(o instanceof LinkedList)) {
            return false;
        }
        // LinkedList<?>: LinkedList with unknown type parameter
        LinkedList<?> lst = (LinkedList<?>) o;
        if (this.size() != lst.size()) {
            return false;
        }
        Node<E> curr_this = this.head;
        LinkedList<?>.Node<?> curr_other = lst.head;
        while (curr_this != null && curr_other != null) {
            if (!areEqual(curr_this.data, curr_other.data)) {
                return false;
            }
            curr_this = curr_this.next;
            curr_other = curr_other.next;
        }
        return true;
    }

    private static boolean areEqual(Object data, Object o)
    {
        return (data == null) ? (o == null) : data.equals(o);
    }
}
