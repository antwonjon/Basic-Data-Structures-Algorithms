
import java.util.ArrayList;

public class Stack<E> {

    private int size = 0;
    private ArrayList<E> stack = new ArrayList<>();

    public void push(E element) {
        stack.add(0, element);
    }

    public E pop() {
        E result = stack.remove(0);
        return result;
    }

    public E peek() {
        E result = stack.get(0);
        return result;
    }

    public int getSize() {
        return stack.size();
    }
    

    public void printStack() {
        while (!stack.isEmpty()) {
            E result = pop();
            System.out.println(result);
        }
    }
    
    public void addToBottom(E element){
    stack.add(element);
    }
    
}
