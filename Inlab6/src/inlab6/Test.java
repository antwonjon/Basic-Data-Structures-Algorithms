package inlab6;

/**
 *
 * @author yaw
 */
public class Test {

    public static void main(String[] args) {

        //System.nanoTime() will give me the current time (it's like looking at the clock)
        //I'll save the current time right (immediately) before I start the thing I want to time
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
        //immediately after the thing I am timing is done, I'll look at the clock again
        //in this case, I'll calculate the elapsed time.
        long elapsed = System.nanoTime() - start;
        System.out.println("That pointless loop took: " + elapsed + " nano seconds");
    }
}
