package outlab2;

/**
 *
 * @author yaw
 */
public class LinkedListQueue<E>{

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListQueue() {

    }

    public void enqueue(E element) {
        Node newNode = new Node(element, null);

        if (size == 0) {
            head = newNode;
        } else {
            tail.setNextNode(newNode);
        }

        tail = newNode;
        size++;
    }

    public E dequeue() {
        if (head != null) {
            E element = head.getElement();
            head = head.getNextNode();
            size--;
            if (size == 0) {
                tail = null;
            }
            return element;
        }
        return null;
    }

    public E getFirst() {
        if (head != null) {
            return head.getElement();
        }
        return null;
    }
    
    public int getSize() {
        return size;
    }

    public void print() {
        if (head != null) {
            Node currentNode = head;
            do {
                System.out.println(currentNode.toString());
                currentNode = currentNode.getNextNode();
            } while (currentNode != null);
        }
        System.out.println();
    }
}
