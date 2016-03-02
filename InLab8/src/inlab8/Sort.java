/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlab8;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author AJ
 */
public class Sort {

    static int i = 0;

    private static <E extends Object & Comparable> void quickSort(E[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <E extends Object & Comparable> void quickSort(E[] array, int startIndex, int endIndex) {

        if (startIndex < endIndex) {

            E pivot = array[endIndex];
            int left = startIndex;
            int right = endIndex - 1;

            while (left <= right) {
                // move the left pointer until it points to bigger than pivot
                while (left <= right && array[left].compareTo(pivot) < 0) {
                    left++;
                }

                while (left <= right && array[right].compareTo(pivot) >= 0) {
                    right--;
                }

                // SWAP!
                if (left <= right) {
                    E temp = array[right];
                    array[right] = array[left];
                    array[left] = temp;
                    left++;
                    right--;
                }
            }

            // Move pivot
            array[endIndex] = array[left];
            array[left] = pivot;

            // Recurse
            quickSort(array, startIndex, left - 1);
            quickSort(array, left + 1, endIndex);

        }
        // else, endIndex>= startIndex
    }

    private static <E extends Object & Comparable> void quickSortHybrid(E[] array) {
        quickSortHybrid(array, 0, array.length - 1);
    }

    private static <E extends Comparable> void quickSortHybrid(E[] array, int startIndex, int endIndex) {

        if (endIndex - startIndex <= 10 && endIndex - startIndex > 1) {
            insertionSort(array, startIndex, endIndex);
        } else if (startIndex < endIndex) {

            E pivot = array[endIndex];
            int left = startIndex;
            int right = endIndex - 1;

            while (left <= right) {
                // move the left pointer until it points to bigger than pivot
                while (left <= right && array[left].compareTo(pivot) < 0) {
                    left++;
                }

                while (left <= right && array[right].compareTo(pivot) >= 0) {
                    right--;
                }

                // SWAP!
                if (left <= right) {
                    E temp = array[right];
                    array[right] = array[left];
                    array[left] = temp;
                    left++;
                    right--;
                }
            }

            // Move pivot
            array[endIndex] = array[left];
            array[left] = pivot;

            // Recurse
            quickSortHybrid(array, startIndex, left - 1);
            quickSortHybrid(array, left + 1, endIndex);

        }
        // else, endIndex>= startIndex
    }

    public static <E extends Comparable> void insertionSort(E[] array, int startIndex, int endIndex) {
        for (int curr = startIndex; curr <= endIndex; curr++) {      
            E temp = array[curr];
            int j = curr - 1;
            while (j >= startIndex && temp.compareTo(array[j]) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;

        }
    }

    public static <E extends Comparable> E[] arrayGenerator() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100000);
        Integer[] array = new Integer[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomNumber;
        }
        return (E[]) array;
    }

    public static <E extends Comparable> void run() {
        long startNormal, endNormal, startHybrid, endHybrid, elapsedNormal, elapsedHybrid = 0;

        E[] array1 = arrayGenerator();
        E[] array2 = arrayGenerator();
        startNormal = System.nanoTime();
        quickSort(array1);
        endNormal = System.nanoTime();
        elapsedNormal = endNormal - startNormal;
        System.out.println("Time it takes for regular quick sort: " + elapsedNormal);

        startHybrid = System.nanoTime();
        quickSortHybrid(array2);
        endHybrid = System.nanoTime();
        elapsedHybrid = endHybrid - startHybrid;
        System.out.println("Time it takes for regular hybrid sort:" + elapsedHybrid);
        
        startNormal = System.nanoTime();
        quickSort(array1);
        endNormal = System.nanoTime();
        elapsedNormal = endNormal - startNormal;
        System.out.println("Time it takes for regular quick sort: " + elapsedNormal);

        startHybrid = System.nanoTime();
        quickSortHybrid(array2);
        endHybrid = System.nanoTime();
        elapsedHybrid = endHybrid - startHybrid;
        System.out.println("Time it takes for regular hybrid sort:" + elapsedHybrid);
    }

}
