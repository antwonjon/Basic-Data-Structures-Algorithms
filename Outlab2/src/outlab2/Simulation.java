package outlab2;

import java.util.*;

/**
 *
 * @author yaw
 */
public class Simulation {

    private final int arrivalRate;
    private final int maxNumQueues;
    private ArrayList<LinkedListQueue<Person>> lines;
    private ArrayList<Integer> times = new ArrayList<>();
    private final double[][] finalTimes;
  

    public Simulation(int arrivalRate, int maxNumQueues) {
        this.arrivalRate = arrivalRate;
        this.maxNumQueues = maxNumQueues;
        finalTimes = new double[maxNumQueues][50];
    }

    public void runSimulation() {
        for (int round = 0; round < 50; round++) {
            for (int j = 1; j <= maxNumQueues; j++) {
                initializeQs(j);
                times = new ArrayList<>();
                for (int minute = 0; minute < 720; minute++) {// for each minute do these methods
                    int peeps = getRandomNumPeople(arrivalRate);
                    placeInShortestLine(peeps, j, minute);
                    removePeople(j, minute);
                }
                System.out.println("The average time for round " + (round+ 1) + ", with " + j + " queues is " + averageTime());
                recordRun(j, averageTime(), round);
            }
        }
        printAverages();
    }

    private void printAverages() {
        for (int i = 0; i < maxNumQueues; i++) {
            double total = 0;
            double average = 0;
            for (int j = 1; j <50; j++) {
               total += finalTimes[i][j];
            }
            average = total/50;
            System.out.println("The average time for " + (i + 1) + " queues is " + average);
        }
    }

    private void recordRun(int qs, double avg, int run) {
        finalTimes[qs-1][run] = avg;
    }

    private double averageTime() {
        int total = 0;
        for (int i = 0; i < times.size(); i++) {
            total += times.get(i);
        }
        return (double) total / times.size();
    }

    private void initializeQs(int numQs) {
        lines = new ArrayList<>();
        for (int f = 0; f < numQs; f++) {
            LinkedListQueue filler = new LinkedListQueue();
            lines.add(filler);
        }
    }

    private LinkedListQueue<Person> getShortest(int curNumQueues) {
        LinkedListQueue<Person> shortest = lines.get(0);
        for (int i = 0; i < curNumQueues; i++) {//Checking each queue to see which one is the shortest
            if (shortest.getSize() > lines.get(i).getSize()) {
                shortest = lines.get(i);
            }
        }
        return shortest;
    }

    public void placeInShortestLine(int peeps, int curNumQueues, int currentMinute) {
        for (int m = 0; m < peeps; m++) {
            LinkedListQueue<Person> shortest = getShortest(curNumQueues);
            shortest.enqueue(new Person(currentMinute));
        }
    }

    public void removePeople(int curNumQueues, int minute) {
        for (int j = 0; j < curNumQueues; j++) {//remove People
            LinkedListQueue<Person> currentList = lines.get(j);
            for (int i = 0; i <= 2 && i < currentList.getSize(); i++) {
                times.add(currentList.dequeue().getWaitTime(minute));     //stores time in ArrayList times
            }
        }
    }

    //Don't change this method.
    private static int getRandomNumPeople(double avg) {
        Random r = new Random();
        double L = Math.exp(-avg);
        int k = 0;
        double p = 1.0;
        do {
            p = p * r.nextDouble();
            k++;
        } while (p > L);
        return k - 1;
    }

    //Don't change the main method.
    public static void main(String[] args) {
        Simulation s = new Simulation(18, 10);
        s.runSimulation();
    }
}
