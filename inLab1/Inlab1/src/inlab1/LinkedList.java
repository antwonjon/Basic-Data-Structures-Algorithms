package inlab1;

/**
 *
 * @author yaw
 */
public class LinkedList {

    private Node head;
    private int size;
//    private Node previousNode;
//    private Node nextNode;

    public LinkedList() {

    }

    public void addInOrder(int value) {
        Node newNode;

        if (head == null) {
            head = new Node(value, null);
            size++;
        } else if (head.getElement() < value) {//before the head

            head = new Node(value, head);

            size++;
        } else if (size == 1) {//after the head
            newNode = new Node(value, null);
            head.setNextNode(newNode);
            size++;
        } else {
            Node currentNode = head;
            newNode = new Node(value, null);
            do {

                if (value > currentNode.getNextNode().getElement()) {
                    newNode.setNextNode(currentNode.getNextNode());
                    currentNode.setNextNode(newNode);
                    size++;
                    return;
                }
                currentNode = currentNode.getNextNode();

            } while (currentNode.getNextNode() != null);
            currentNode.setNextNode(newNode);
        }

    }

    public void removeAtIndex(int index) {
        Node currentNode = head;
        Node previousNode = head;
        if (index > size) {
        } else if (index == 1) {//if you want to remove from position 1
            head = head.getNextNode();

            size--;

        } else if (index <= size) { //if you want to remove anywhere else
            int i = 1;
            while (i < index - 1) {
                currentNode = currentNode.getNextNode();
                i++;
            }
            currentNode.setNextNode(currentNode.getNextNode().getNextNode());
            size--;

        } else if (size == index) {//if you want to remove the last one?
            int i = 1;
            while (i < index - 1) {
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
                i++;
            }
            previousNode.setNextNode(null);

        }
    }

    public void printList() {
        if (head != null) {
            Node currentNode = head;
            int i = 1;
            do {
                System.out.println(i + ") " + currentNode.getElement());
                i++;
                currentNode = currentNode.getNextNode();
            } while (currentNode != null);
        }
        System.out.println();
    }
}
