/**
 * Author: Charles T. Carter
 * Date: 10/31/2024
 *
 * This program creates a text file called "Exercise17_01.txt" and writes 100
 * random integers into it, if the file already exists it writes 100 more.
 */

import java.io.*;

public class InputOutput_Fundamental {
    public static void main(String[] args) throws IOException {
        try ( PrintWriter output = new PrintWriter( new FileOutputStream("Exercise17_01.txt", true));) {
            for (int i = 0; i < 100; i++) {
                output.print((int)(Math.random() * 20) + 1);
                output.print(" ");
            }
        }
    }
}
