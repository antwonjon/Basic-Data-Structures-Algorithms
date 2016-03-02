package inlab4;

/**
 *
 * @author yaw
 */
public class Search {

    public static boolean binarySearch(int[] array, int value) {
        return binarySearchHelper(array, value, 0, array.length);
    }

    private static boolean binarySearchHelper(int[] array, int value, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (value == array[mid]) {
                return true;
            } else if (value < array[mid]) {
                return binarySearchHelper(array, value, low, mid - 1);
            } else {
                return binarySearchHelper(array, value, mid + 1, high);
            }
        }
        return false;
    }

    public static boolean linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            } else if (array[i] > value) {
                return false;
            }
        }
        return false;
    }
}
