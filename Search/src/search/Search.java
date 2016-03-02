/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 *
 * @author v65g526
 */
public class Search {

    
    private static int binarySearch(int[] array, int value){
        return binarySearchHelper(array, value, 0, array.length-1);
    }
    
    private static int binarySearchHelper(int[] array, int value, int low, int high){
          
        
        if (low > high){
            System.out.println("low="+low + "\t" +  "high="+high);
            return -1;
        }        
        int mid = (low + high) / 2;        
        
        System.out.println("low="+low + "\t" + "mid="+mid + "\t" + "high="+high + "\t" + array[mid]);
        
        if (value == array[mid] ){
            // Found
            return mid;
        }else if (value < array[mid]){
            // Lower half of array
            return binarySearchHelper(array, value, low, mid - 1);
        }else if (value > array[mid]){
            // Upper half
             return binarySearchHelper(array, value, mid + 1 , high);
        }
        return -1;
    }
    
    
    
    

    public static void main(String[] args) {
        int[] array = {7, 7, 9, 12, 18, 34, 52, 54, 59};
        System.out.println(""+binarySearch(array, 11));   
    }
    
}
