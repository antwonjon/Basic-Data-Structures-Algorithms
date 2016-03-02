
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        s1.push(1);
        System.out.println("pushing 1");
        s1.push(3);
        System.out.println("pushing 3");
        s1.push(2);
        System.out.println("pushing 2");
        s1.push(6);
        System.out.println("pushing 6");
        System.out.println("peeking " + s1.peek());
        s1.peek();
        s1.pop();
        System.out.println("popping 6");
        s1.pop();
        System.out.println("popping 2");
        s1.push(10);
        System.out.println("pushing 10");

        s1.printStack();

        s2.push(3);
        s2.push(2);
        s2.push(7);
        s2.push(3);
        s2.pop();
        s2.pop();
        s2.push(11);

       Stack doubleStack = mergeStacks(s1, s2);
       doubleStack.printStack();
    }

    public static Stack<Integer> mergeStacks(Stack<Integer> stack1, Stack<Integer> stack2) {
        Stack<Integer> temp = new Stack<>();
        while (stack1.getSize() > 0) {
            Integer element = stack1.pop();
            temp.push(element);
        }
        while (temp.getSize() > 0) {
            Integer element = temp.pop();
            stack2.push(element);
        }
        return stack2;
    }
}
