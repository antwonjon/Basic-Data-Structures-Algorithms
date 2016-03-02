package inlab1;

/**
 *
 * @author yaw
 */
public class Node {
    private int element;
    private Node next;
    
    public Node(int element, Node next) {
        this.element = element;
        this.next = next;
    }
    
    public void setNextNode(Node next) {
        this.next = next;
    }
    
    public Node getNextNode() {
        return next;
    }
    
    public int getElement() {
        return element;
    }
}
