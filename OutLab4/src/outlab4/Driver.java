package outlab4;

public class Driver {

    public static void main(String[] args) {
        boolean done = false;
        Tree tree = new Tree();
        Node root = new Node();
        tree.initializeTree();
        while (!done) {
            done = tree.initialQuestion();
            if(done!=true){
                tree.askQuestion(tree.root);
            }
            
        }

    }
}
