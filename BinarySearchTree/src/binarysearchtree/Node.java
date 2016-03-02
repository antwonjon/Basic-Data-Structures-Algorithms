
package binarysearchtree;

/**
 *
 * @author v65g526
 */
public class Node<E extends Comparable> {
    
    private E value;
    private Node<E> left;
    private Node<E> right;
    private Node<E> parent;
       
    
    public Node(E value){
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public String toString(){
        return this.getValue().toString();
    }

    
    
    
}
