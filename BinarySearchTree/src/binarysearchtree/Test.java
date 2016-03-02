package binarysearchtree;

/**
 *
 * @author v65g526
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insertRec(44);
        bst.insertRec(17);
        bst.insertRec(88);
        bst.insertRec(8);
        bst.insertRec(32);
        bst.insertRec(65);
        bst.insertRec(97);
        bst.insertRec(28);
        bst.insertRec(54);
        bst.insertRec(82);
        bst.insertRec(93);
        bst.insertRec(21);
        bst.insertRec(29);
        bst.insertRec(76);
        bst.insertRec(68);
        bst.insertRec(80);
        
        PrintTree.printTree(bst); 
        System.out.println("\n\n");
        
        
        
        //System.out.println("Found "+bst.search(76));
        //System.out.println("Found "+bst.search(1901));
        
        bst.remove(44);
        PrintTree.printTree(bst); 
        
        
//        bst.remove(44);        
//        PrintTree.printTree(bst);        
    }
}
