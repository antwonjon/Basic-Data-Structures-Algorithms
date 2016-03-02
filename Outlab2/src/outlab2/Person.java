/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab2;

/**
 *
 * @author AJ
 */
public class Person {
    private int startingTime;

    public Person(int startingTime) {
        this.startingTime = startingTime;
    }

    public int getWaitTime(int currentTime) {
        return (currentTime-startingTime);
    }
    
   

}
