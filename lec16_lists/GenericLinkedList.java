public class GenericLinkedList<E>
{

    private class Node<T>
    { // inner class
        T data; // no modifier = package-private
        Node<T> next;

        Node(T data, Node<T> next)
        {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head; // the only instance variable of the list

    public GenericLinkedList()
    {

        head = null; // the list starts off empty
    }

    public boolean isEmpty()
    {
        return (head == null); // the list is empty if head is null
    }

    public void addToFront(E newData)
    {
        head = new Node<E>(newData, head);
    }

    public void addToRear(E newData)
    {
        Node<E> node = new Node<E>(newData, null);
        Node<E> current = head;
        if (isEmpty()) // point head to new node if list is empty
            head = node;
        else {
            while (current.next != null) { // the last node is the one with next = null
                current = current.next;
            }
            current.next = node;
        }
    }

    public E removeFromFront()
    {
        if (isEmpty()) {
            return null;
        }
        else {
            Node<E> removedNode = head;
            head = head.next;
            return removedNode.data;
        }
    }

    public E removeFromRear()
    {
        if (isEmpty()) {
            return null;
        }
        else if (head.next == null) {
            return removeFromFront();
        }
        else {
            Node<E> prev = head;
            Node<E> curr = head.next;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            return curr.data;
        }
    }

    public String toString()
    {

        Node<E> current = head; // traversal starts at the front
        String result = ""; // result starts empty

        while (current != null) { // keep going until there's no more nodes to point to
            result = result + current.data.toString() + "\n";
            current = current.next; // move over to next node
        }
        return result;
    }

    public boolean contains(E target)
    {
        if (isEmpty()) { // empty lists can't contain the target
            return false;
        }

        boolean found = false;
        Node<E> current = head; // traversal starts at the front

        while ((current != null) && (!found)) {
            if (target.equals(current.data)) {
                found = true;
            }
            else {
                current = current.next;
            }
        }
        return found;
    }

    public static void main(String[] args)
    {
        GenericLinkedList<String> favBabySongs = new GenericLinkedList<>();
        favBabySongs.addToFront("Humpty Dumpty");
        favBabySongs.addToRear("Swing Low Sweet Chariot");
        favBabySongs.addToFront("Itsy Bitsy Spider");
        favBabySongs.addToRear("Twinkle, Twinkle Little Star");
        favBabySongs.addToFront("Wheels on the Bus");
        System.out.println(favBabySongs.toString());
        System.out.println(favBabySongs.contains("Humpty Dumpty"));
        System.out.println(favBabySongs.contains("Baby Shark"));
        System.out.println("");
        favBabySongs.removeFromFront();
        System.out.println(favBabySongs.toString());
        System.out.println("");
        favBabySongs.removeFromRear();
        System.out.println(favBabySongs.toString());
    }
}
