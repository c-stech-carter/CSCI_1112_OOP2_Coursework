/**
 * Author: Charles Carter
 * Date: 11/6/2024
 *
 * This program uses recursion to reverse a String entered by the user.
 */


import java.util.Scanner;

public class Programming18_09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String string = input.nextLine();

        System.out.print("\nThe string reversed is: ");
        reverseDisplay(string);

    }

    public static void reverseDisplay(String value) {
        if (value.isEmpty()) {
            return; // Base case: do nothing for an empty string
        } else {
            System.out.print(value.charAt(value.length() - 1));
            reverseDisplay(value.substring(0, value.length() - 1)); // Recursive call
        }

    }
}
