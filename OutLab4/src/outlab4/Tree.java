package outlab4;

import java.util.Scanner;

public class Tree {

    public Node root;
    private Scanner scan = new Scanner(System.in);
    Node newAnimal;
    String location = "";
   

    public Tree() {
        root = null;
    }
    public void initializeTree(){
        Node initial;
        Node newNodeYes = new Node();
        Node newNodeNo = new Node();
        initial = new Node();
        root = initial;
        initial.setAttribute("fur");
        initial.setYes(newNodeYes);
        initial.setNo(newNodeNo);
        newNodeYes.setName("dog");
        newNodeYes.setAttribute("bark");
        newNodeNo.setName("snake");
        newNodeNo.setAttribute("forked tongue");
    }
            
    public boolean initialQuestion() {
        location = "";
        System.out.println("Would you like me to guess another animal?");
       String flag = "";
        while (!flag.equals("y") && !flag.equals("n")) {
            
            flag = scan.next();
            if (flag.equals("y")) {
                return false;
            }
            if (flag.equals("n")) {
                return true;
            }
        }
        return true;
    }

    public boolean checkAnswer() {
       String flag = "";
        while (!flag.equals("y") && !flag.equals("n")) {
            
            flag = scan.next();
            if (flag.equals("y")) {
                return true;
            }
            if (flag.equals("n")) {
                return false;
            }
        }
        return true;
    }

    public void askQuestion(Node current) {
       
        boolean check;
        if (current.getNo() != null || current.getYes() != null) {
            System.out.println("Does your animal have " + current.getAttribute() + "?");
            check = checkAnswer();
            if (check == true) {
                location += current.getAttribute() + ",";
                askQuestion(current.getYes());
            } else if (check == false) {
                location += "no " + current.getAttribute() + ", ";
                askQuestion(current.getNo());
            }
        } else if (current.getNo() == null && current.getYes() == null) {
            System.out.println("Is your animal a(n) " + current.getName() + "?");
            check = checkAnswer();
            if(check==true){
                System.out.println("I'm pretty good at guessing, huh?");
            }
            else if(check==false){     
                newAnimal(current);
            }
        }
    }
    
  

    public void newAnimal(Node current) {
        System.out.println("I don't know any animals that have " + location + " no " + current.getAttribute());
        
        //create new animal
        newAnimal = new Node();
        current.setNo(newAnimal);
        System.out.println("What is this new animal's name?"); 
        String name = scan.next();
        current.getNo().setName(name);
        System.out.println("What makes your animal different than a " + current.getName() + "?");
        String attribute = scan.next();
        current.getNo().setAttribute(attribute);   
        System.out.println("");
        
        //add old animal 
        Node oldAnimal = new Node();
        current.setYes(oldAnimal);
        oldAnimal.setName(current.getName());
        oldAnimal.setAttribute(current.getAttribute());
        
    }
}
