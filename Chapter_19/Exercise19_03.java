/*
Author: Charles Carter
Date: 11/11/2024


Description: This program uses the generic method removeDuplicates() to get
rid of objects in an ArrayList that are redundant.

( I did not write the main method, just the method removeDuplicates() as required by
 the assignment.)
 */
import java.util.ArrayList;

public class Exercise19_03 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }


  //Method I've added according to the assignment
  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
    ArrayList<E> newList = new ArrayList<>();
      for (E element: list) {  //Simplified drastically using a for-each loop
        if (!newList.contains(element)) {   //Uses ArrayList's methods to tell if an
          newList.add(element);             //item is already in the list and then adds
        }                                   //adds it to newList, if not.
      }
      return newList;  //Returns the new ArrayList
  }
}
