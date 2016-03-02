package binarysearchtree;

/**
 *
 * @author v65g526
 */
public class BST<E extends Comparable> {
    
    Node<E> root;
    
    public BST() {
        root = null;
    }
    
    public void insertRec(E newValue) {
        if (root != null) {
            insertRec(newValue, root);
        } else {
            root = new Node(newValue);
        }
    }
    
    private void insertRec(E newValue, Node n) {
        
        if (newValue.compareTo(n.getValue()) < 0) {
            //left
            if (n.getLeft() == null) {
                n.setLeft(new Node(newValue));
                n.getLeft().setParent(n);
            } else {
                insertRec(newValue, n.getLeft());
            }
        } else {
            // right
            if (n.getRight() == null) {
                n.setRight(new Node(newValue));
                n.getRight().setParent(n);
            } else {
                insertRec(newValue, n.getRight());
            }
        }
    }
    
    public Node<E> search(E value) {
        return search(value, root);
    }
    
    private Node<E> search(E value, Node n) {
        
        if (n == null) {
            return null;
        } else if (value.compareTo(n.getValue()) == 0) {
            return n;
        } else if (value.compareTo(n.getValue()) < 0) {
            // left
            return search(value, n.getLeft());
        } else {
            // right
            return search(value, n.getRight());
        }
    }
    
    public boolean remove(E value) {
        Node rn = search(value);
        return remove(rn);
    }
    
    private boolean remove(Node rn) {
        
        System.out.println("\tRemoving node " + rn.toString());
        
        if (rn == null) {
            return false;
        }
        
        if (rn.getLeft() == null || rn.getRight() == null) {
            if (rn.getLeft() != null) {
                // we have a left child
                // Promote from the left
                if (rn == root) {
                    root = rn.getLeft();
                    root.setParent(null);                    
                }else if (rn.getParent().getRight() == rn){
                    rn.getParent().setRight( rn.getLeft() );
                }else{
                    rn.getParent().setLeft(rn.getLeft());
                }
                rn.getLeft().setParent(rn.getParent());
            } else if (rn.getRight() != null) {
                // we have a right child, and no left
                
                // Promote from the right
                if (rn == root) {
                    root = rn.getRight();
                    root.setParent(null);                    
                }else if (rn.getParent().getRight() == rn){
                    rn.getParent().setRight( rn.getRight() );
                }else{
                    rn.getParent().setLeft(rn.getRight());
                }
                rn.getRight().setParent(rn.getParent());
                
                
            } else {
                // we have no children
                if (rn == root) {
                    root = null;                    
                } else if (rn.getParent().getRight() == rn) {
                    rn.getParent().setRight(null);
                } else {
                    rn.getParent().setLeft(null);
                }
            }
        } else {
            // we have two children
            
            Node left = rn.getLeft();
            Node next = left;
            while ( next.getRight() != null ){
                next = next.getRight();                
            }
            
            rn.setValue(next.getValue());
            remove(next);
            
        }   
        
        return true;
    }
    
}
