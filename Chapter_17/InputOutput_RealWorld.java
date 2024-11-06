/**
 * Author: Charles Carter
 * Date: 11/4/2024
 *
 * This program creates a binary file named "Exercise 17_03.dat" and randomly
 * writes 100 integers to it.  I've arbitrarily limited the number range from 1 to 20.
 * Every time the program runs, it appends 100 more integers to the file if it already exists.
 *
 * Its second method reads the file and gives a count of current total of integers in
 * the file, and their sum.
 */

import java.io.*;

public class InputOutput_RealWorld {
    public static void main(String[] args) throws IOException {
        CreateFile();
        ReadFile();
    }

    public static void CreateFile () throws IOException {
        try (DataOutputStream file =
                     new DataOutputStream(new FileOutputStream("Exercise17_03.dat", true))) {
            for (int i = 0; i < 100; i++) {
                file.writeInt((int) (Math.random() * 20) + 1);
            }
        }
    }

    public static void ReadFile () throws IOException {
        try (DataInputStream file =
                     new DataInputStream(new FileInputStream("Exercise17_03.dat"))) {
            int count = 0;
            int sum = 0;
            while (true) {
                try {
                    sum += file.readInt();
                    count++;  //I added this just to keep track of how many integers
                              //are in the file, because with repeated running it
                              //could get really large and confusing.
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("There are " + count + " integers in Exercise17_03.dat");
            System.out.println("The sum of the integers is: " + sum);
        }
    }
}
