package inlab3;

public class Node<E> {
    private E element;
    private Node next;
    
    public Node(E element, Node next) {
        this.element = element;
        this.next = next;
    }
    
    public void setNextNode(Node next) {
        this.next = next;
    }
    
    public Node getNextNode() {
        return next;
    }
    
    public E getElement() {
        return element;
    }

    @Override
    public String toString() {
        return element.toString();
    }
    
    
}