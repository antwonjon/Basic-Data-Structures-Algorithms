package phonelist;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author yaw
 */
public class LinkedList {

    private Node head;
    private int size = 0;

    public LinkedList() {
        load(); // Load a contacts from a file
    }

    public void add(Contact contact) {
        Node newContact;
        if (head == null) {
            head = new Node(contact, null);
            size++;
            //adding first contact if list doesn't exist yet
        } else if (head.getContact().getName().compareTo(contact.getName()) > 0) {
            head = new Node(contact, head);
            size++;
            //before the head/ creates new head

        } else if (size == 1) {//adding after the head
            newContact = new Node(contact, null);
            head.setNextNode(newContact);
            size++;

        } else {
            Node currentNode = head;
            newContact = new Node(contact, null);
            do {

                if (currentNode.getNextNode().getContact().getName().compareTo(contact.getName()) > 0) {
                    newContact.setNextNode(currentNode.getNextNode());
                    currentNode.setNextNode(newContact);
                    size++;

                    //adding middle contact
                    return;
                }
                currentNode = currentNode.getNextNode();

            } while (currentNode.getNextNode() != null);
            currentNode.setNextNode(newContact);
            size++;
            //adding last contact
        }
    }

    public boolean remove(String name) {
        Node currentNode = head;
        Node previousNode = head;
        boolean done = false;
        if (head == null) {
            //list is empty, can't remove
            return false;
        } else if (size == 1) {
            head = null;
            size--;
            //list is only size 1 and you remove it
            return true;
        } else if (head.getContact().getName().compareTo(name) == 0) {
            head = head.getNextNode();
            size--;
            return true;
            //if names are equal to one another
        } else {
            while (!done) {
                if (currentNode.getContact().getName().compareTo(name) == 0) {
                    previousNode.setNextNode(currentNode.getNextNode());
                    //this gets through the list and even includes the final person to remove
                    return true;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();

            }
        }
        return false;
    }

    public Contact search(String name) {
        Node currentNode = head;
        if (head == null) {
            return null;
        } else {
            currentNode = head;
            while (currentNode != null) {
                if (currentNode.getContact().getName().equals(name)) {
                    return currentNode.getContact();
                }
                currentNode = currentNode.getNextNode();
            }
        }
        return null;
    }

    public String getAll() {
        String output = "";
        if (head != null) {
            Node currentNode = head;
            int i = 1;
            do {
                output += i + ") " + currentNode.getContact().getName() + "\n";
                i++;
                currentNode = currentNode.getNextNode();
            } while (currentNode != null);
        }
        
        return output;

    }

    /**
     * Save contacts to a text file *
     */
    public void save() {
        if (size == 0) {
            return;
        }

        Scanner in = new Scanner(System.in);
        try {
            PrintWriter outFile = new PrintWriter("contacts.txt");

            if (head != null) {
                Node currentNode = head;
                do {
                    Contact contact = currentNode.getContact();
                    outFile.println(contact.getName() + "," + contact.getNumber());
                    currentNode = currentNode.getNextNode();
                } while (currentNode != null);
            }

            outFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find that file");
        }
    }

    /**
     * Load contacts from a text file *
     */
    public void load() {
        try {
            FileReader file = new FileReader("contacts.txt");
            Scanner inFile = new Scanner(file);

            while (inFile.hasNext()) {
                String contact = inFile.nextLine();
                int index = contact.indexOf(',');
                String name = contact.substring(0, index);
                String number = contact.substring(index + 1, contact.length());
                add(new Contact(name, number));
            }

            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find that file");
        }
    }

}
