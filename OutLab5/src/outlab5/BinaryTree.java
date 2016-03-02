/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab5;

import java.util.ArrayList;

/**
 *
 * @author yaw
 */
public class BinaryTree<E extends Comparable> {

    Node<E> root;
    final private static Node[] inOrder = new Node[10];
    private static int i = 0;

    public BinaryTree() {
        root = null;
    }

    public static <E extends Comparable> void insertArray(E[] array) {
        BinaryTree tree = new BinaryTree();
        
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
        addToArray(tree.root, array);
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

    private static <E extends Comparable> void addToArray(Node current, E[] array) {
        if (current.getLeft() != null) {
            addToArray(current.getLeft(), array);
        }
        array[i] = (E)current.getValue();
        i++;
        if (current.getRight() != null) {
            addToArray(current.getRight(), array);
        }

    }


    public static <E extends Comparable> void printArray(E[] array) {
        String print = "";
        for (int j = 0; j < array.length; j++) {
            print += " " + array[j];
        }
        System.out.println(print);
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
