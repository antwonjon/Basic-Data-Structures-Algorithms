package inlab3;

import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        LinkedListQueue q1 = new LinkedListQueue();
        LinkedListQueue q2 = new LinkedListQueue();
        q1 = randomOrderedQueue(10);
        q1.printList();
        q2 = randomOrderedQueue(10);
        q2.printList();

        LinkedListQueue mergedList = merge(q1, q2);
        mergedList.printList();
    }

    public static LinkedListQueue randomOrderedQueue(int size) {
        Random rand = new Random();
        LinkedListQueue queue = new LinkedListQueue();
        int randomNum = 0;
        int i = 0;
        while (i < size) {
            randomNum += rand.nextInt(100);
            queue.enqueue(randomNum);
            i++;
        }
        return queue;
    }

    public static LinkedListQueue merge(LinkedListQueue<Integer> q1, LinkedListQueue<Integer> q2) {
        LinkedListQueue mergedList = new LinkedListQueue();
        int size = q1.getSize() + q2.getSize();
        int s1 = q1.getSize();
        int s2 = q2.getSize();
        int temp;
        while (size > 0) {
            if (s1 == 0 || s2 == 0) {//use this IF when either q1 or q2 is empty
                if (s1 != 0) {
                    while (s1 != 0) {//when q2 empty
                        mergedList.enqueue(q1.first());
                        q1.enqueue(q1.dequeue());
                        size--;
                        s1--;
                    }
                } else if (s2 != 0) {
                    while (s2 != 0) {//when q1 empty
                        mergedList.enqueue(q2.first());
                        q2.enqueue(q2.dequeue());
                        size--;
                        s2--;
                    }
                }
            } else if (q1.first() <= q2.first()) {//when q1 smaller or equal to q2
                mergedList.enqueue(q1.first());//adds first element in q1 to mergedList
                q1.enqueue(q1.dequeue());//adds first element to tail of q1
                size--;
                s1--;
            } else if (q2.first() < q1.first()) {//when q2 smaller than q1
                mergedList.enqueue(q2.first());
                q2.enqueue(q2.dequeue());
                size--;
                s2--;
            }
        }

        return mergedList;
    }
}
