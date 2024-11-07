/**
 * Author: Charles Carter
 * Date: 11/6/2024
 *
 * This program uses recursion to find the greatest common divisor of 2 integers.
 * I've modified it to also work with negative numbers
 */


import java.util.Scanner;

public class Recursion_Fundamental {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int num1 = input.nextInt();

        System.out.print("Enter a second integer: ");
        int num2 = input.nextInt();

        System.out.println("The greatest common divisor of " + num1 +
                " and " + num2 + " is " + gcd(num1, num2));
    }

    public static int gcd(int m, int n) {
        m = Math.abs(m); //To adjust if either integer
        n = Math.abs(n); //is negative
        if (m%n == 0) return n;
        else return gcd(n, m%n);
    }
}
