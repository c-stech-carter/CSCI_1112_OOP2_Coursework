import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Author: Charles Carter
 * Date: 11/5/2024
 *
 *This program encrypts a file of the user's choice by adding 5 to every byte in the file.
 */


public class Exercise17_14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program encrypts a file of your choosing.");
        System.out.print("Enter file name:> ");
        String inputFileName = input.nextLine();
        System.out.print("Enter output file name:> ");
        String outputFileName = input.nextLine();

        try (
                FileInputStream inputFile = new FileInputStream(inputFileName);
                FileOutputStream outputFile = new FileOutputStream(outputFileName);
        ) {
            int byteData;
            while ((byteData = inputFile.read()) != -1) {
                outputFile.write(byteData + 5);  //Encrypt by adding 5 to each byte
            }
            System.out.println("File encrypted as " + outputFileName);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
