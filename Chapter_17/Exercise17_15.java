import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Author: Charles Carter
 * Date: 11/5/2024
 *
 * This program prompts for file names, and decrypts a file by subtracting 5 from each byte of the file.
 */

public class Exercise17_15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program decrypts a file of your choosing.");
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
                outputFile.write(byteData - 5);  //Decrypt by subtracting 5 from the byte data
            }
            System.out.println("The file has been decrypted as " + outputFileName);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
