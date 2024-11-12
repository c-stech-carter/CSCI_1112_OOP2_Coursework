/*
Author: Charles Carter
Date: 11/11/2024

Description: This program sorts an ArrayList from lowest to largest value.
I did not create the main method, just the generic method sort(), as required by the assignment.
It uses compareTo() to sort the ArrayList elements and should work on any ArrayList type.
*/
import java.util.ArrayList;

public class Exercise19_09 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(4);
    list.add(42);
    list.add(5);
    Exercise19_09.<Integer>sort(list);
    
    System.out.print(list);
  }

  public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
    for (int i = 0; i < list.size(); i++) { //For loop for each element in the list
      int minIndex = i;
      for (int j = i + 1; j < list.size(); j++) {  //Nested for loop for sorting
        if (list.get(minIndex).compareTo(list.get(j)) > 0) {
          minIndex = j;  //checks if the list at 'minIndex' currently is smaller than
        }                //the list being checked at 'j', and assigns it to minIndex, if it is.
      }
      E temp = list.get(i);  //Store value of current index in temporary variable
      list.set(i, list.get(minIndex));  //places the smallest value at current index
      list.set(minIndex, temp);  // Place the original value at the position of the smallest value
    }
  }
}
