/*
Author: Charles Carter
Date: 11/11/2024

Description: This program uses a generic method called 'max' to get the
max value of some comparable objects in arrays.

I did not write the main method, just max(), which was required by the assignment.
 */
public class Exercise19_05 {
  public static void main(String[] args) {
    Integer[] numbers = {1, 2, 3};
    System.out.println(max(numbers));
    
    String[] words = {"red", "green", "blue"};
    System.out.println(max(words));
    
    Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};
    System.out.println(max(circles));
  }

  //Method I've added according to the assignment
  public static <E extends Comparable<E>> E max(E[] list) {
    E max = list[0];  //Sets 'max' to the first element in the array passed
                      //to the method
    for (E element: list) {  //A for-each loop simplifies this a lot
      if (max.compareTo(element) < 0) {   //Uses compareTo method to check
        max = element;                    //if 'max' is less than the current
      }                                   //element in the for-each loop.  It then
    }                                     //assigns that to 'max', if it is.
    return max;  //Returns the max value
  }
  
  static class Circle implements Comparable<Circle> {
    double radius;
    
    public Circle(double radius) {
      this.radius = radius;
    }
    
    @Override
    public int compareTo(Circle c) {
      if (radius < c.radius) 
        return -1;
      else if (radius == c.radius)
        return 0;
      else
        return 1;
    }
    
    @Override
    public String toString() {
      return "Circle radius: " + radius;
    }
  }
}
