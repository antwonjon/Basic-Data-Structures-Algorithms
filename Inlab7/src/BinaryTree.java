
import java.util.LinkedList;
import java.util.ArrayList;

/**
 *
 * @author yaw
 */
public class BinaryTree<E extends Comparable> {

    public Node<E> root;
    final private static ArrayList<Node> inOrder = new ArrayList<>();

    public BinaryTree() {
        root = null;
    }

    public void insert(E newValue) {
        if (root == null) {
            root = new Node(newValue);
        } else {
            Node currentNode = root;
            boolean placed = false;
            while (!placed) {
                if (newValue.compareTo(currentNode.getValue()) < 0) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(new Node(newValue));
                        currentNode.getLeft().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(new Node(newValue));
                        currentNode.getRight().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getRight();
                    }
                }
            }
        }
    }

    public boolean isBST() {
        boolean flag = true;
        return flag = isBST(root);
    }

    private boolean isBST(Node current) {
        if (current.getLeft() != null) {
            isBST(current.getLeft());
        }
        inOrder.add(current);
        if (current.getRight() != null) {
            isBST(current.getRight());
        }

        return isInOrder();

    }

    private boolean isInOrder() {
        int i = 1;
        while (i < inOrder.size()) {
            if (inOrder.get(i).getValue().compareTo(inOrder.get(i - 1).getValue()) < 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static String printInOrder() {
        int i = 0;
        String print = "";
        while (i < inOrder.size()) {
            System.out.print(" " + inOrder.get(i).getValue());
            i++;
        }
        return print;
    }

    public void modify(E value1, E value2) {
        Node<E> a = search(value1, root);
        a.setValue(value2);

    }

    public Node<E> search(E value, Node<E> n) {
        if (n == null) {
            return null;
        } else if (value.compareTo(n.getValue()) == 0) {
            System.out.println("you made it");
            return n;
        } else if (value.compareTo(n.getValue()) < 0) {
            System.out.println(n.getValue());
            return search(value, n.getLeft());
        } else if (value.compareTo(n.getValue()) > 0) {
            System.out.println(n.getValue());
            return search(value, n.getRight());

        }
        return null;
    }

}
