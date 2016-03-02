/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlab5;

/**
 *
 * @author AJ
 * @param <E>
 */
public class Search<E extends Comparable> {        //Whatever E you pass to it will have to extend Comparable, ints, strings, doubles - You can't compare espresso and latte

    public int Search(E[] array, E element) {       // This search method takes an array of type E(i.e. Generic array) and also a generic element
        int low = 0;
        int high = array.length - 1;
        while (high >= low) {                                     //This while statement catches when the high and low are equal to each other so the search can stop
            int mid = (high + low) / 2;                           //This resets the mid
            if (array[mid].compareTo(element) > 0) {              //This if statement catches the lower half of the range
                high = mid - 1;
            } else if (array[mid].compareTo(element) < 0) {       //This if statement catches the upper half of the range
                low = mid + 1;
            } else {
                return mid;                                       //This returns when the element is in the array
            }
        }
        return -1;                                                //This returns when the element is not in the array 
    }
}
