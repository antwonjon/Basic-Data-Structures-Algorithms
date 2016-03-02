package phonelist;

public class Node {
    private Contact contact;
    private Node next;

    public Node(Contact contact, Node next) {
        this.contact = contact;
        this.next = next;
    }

    public Node getNextNode() {
        return next;
    }

    public void setNextNode(Node next) {
        this.next = next;
    }
   
    public Contact getContact() {
        return contact;
    }
}
