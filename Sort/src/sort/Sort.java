/*
 */
package sort;

import java.util.Arrays;

/**
 *
 * @author v65g526
 */
public class Sort {

    public static <E extends Comparable> void insertionSort(E[] array) {
        for (int curr = 0; curr < array.length; curr++) {
            System.out.println("curr = " + curr);
            E temp = array[curr];
            int j = curr - 1;

            System.out.println("j=" + j);
            while (j >= 0 && temp.compareTo(array[j]) < 0) {
                System.out.print("" + j + ",");
                array[j + 1] = array[j];
                j--;
            }
            System.out.println("\nSwapping " + array[j + 1] + " and " + temp);
            array[j + 1] = temp;
            System.out.println("-----");
        }
    }

    public static <E extends Comparable> void quickSort(E[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <E extends Comparable> void quickSort(E[] array, int startIndex, int endIndex) {

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

    public static <E extends Comparable> void mergeSort(E[] array) {

        if (array.length >= 2) {
            // Divide
            int mid = array.length / 2;
            E[] a1 = Arrays.copyOfRange(array, 0, mid);
            E[] a2 = Arrays.copyOfRange(array, mid, array.length);

            // Conquer
            mergeSort(a1);
            mergeSort(a2);

            // Merge 
            merge(a1, a2, array);
        }
    }

    private static <E extends Comparable> void merge(E[] a1, E[] a2, E[] array) {
        int i = 0, j = 0;
        while (i + j < array.length) {
            if (i == a1.length) {
                array[i + j] = a2[j];
                j++;
            } else if (j == a2.length) {
                array[i + j] = a1[i];
                i++;
            } else if (a1[i].compareTo(a2[j]) <= 0) {
                array[i + j] = a1[i];
                i++;
            } else {
                array[i + j] = a2[j];
                j++;
            }
        }
    }

}
