/*
 */
package sort;

/**
 *
 * @author v65g526
 */
public class Test {
    
        public static void main(String[] args) {
            Integer[] array = {85, 24, 63, 45, 17, 31,96, 50};
            
            System.out.print("Unsorted: ");
            printArray(array);
            //Sort.mergeSort(array);            
            //Sort.quickSort(array);            
            Sort.insertionSort(array);
            
            
            System.out.print("Sorted: ");
            printArray(array);
        }
               
        private static void printArray(Integer[] arr){
            for (int e : arr) {
                System.out.print(""+e + ", ");                
            }
            System.out.println("");
        }
}
