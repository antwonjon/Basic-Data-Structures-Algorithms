package inlab4;

import java.util.Random;

/**
 *
 * @author yaw
 */
public class Test {

    public static void main(String[] args) {
        long totalBinary = 0;
        long totalLinear = 0;
        for (int m = 0; m < 2000; m++) {
            int[] anArray = new int[2750];
            Random rand = new Random();
            int randomNumber = rand.nextInt();
            for (int j = 0; j < 2750; j++) {
                if (j == 0) {
                    int value = 0;
                    value += rand.nextInt(200);
                    anArray[j] = value;
                } else {
                    anArray[j] = rand.nextInt(200) + anArray[j - 1];
                }
            }
            long startBinary = 0;
            long elapsedBinary = 0;

            for (int i = 0; i < 2000; i++) {
                randomNumber = rand.nextInt(anArray[anArray.length - 1]);
                startBinary = System.nanoTime();
                Search.binarySearch(anArray, randomNumber);
                elapsedBinary = System.nanoTime() - startBinary;
                totalBinary += elapsedBinary;
            }
            totalBinary = totalBinary / 2000;

            long startLinear = 0;
            long elapsedLinear = 0;

            for (int k = 0; k < 2000; k++) {
                randomNumber = rand.nextInt(anArray[anArray.length - 1]);
                startLinear = System.nanoTime();
                Search.linearSearch(anArray, randomNumber);
                elapsedLinear = System.nanoTime() - startLinear;
                totalLinear += elapsedLinear;
            }
            totalLinear= totalLinear/ 2000;
            
        }
        long avgBinary = totalBinary;
        long avgLinear = totalLinear;
        System.out.println("Binary: " + avgBinary + "\nLinear: " + avgLinear);

    }
}
