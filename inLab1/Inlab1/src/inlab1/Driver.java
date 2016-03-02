/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlab1;

/**
 *
 * @author yaw
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.removeAtIndex(2);
        list.addInOrder(5);
        list.addInOrder(1);
        list.addInOrder(4);
        list.addInOrder(6);
        list.addInOrder(-1);
        list.printList();

        list.addInOrder(8);
        list.addInOrder(5);
        list.printList();

        list.removeAtIndex(1);
        list.printList();

        list.removeAtIndex(3);
        list.printList();

        list.removeAtIndex(5);
        list.printList();

        list.removeAtIndex(7);
    }

}
