/**
 * Author: Charles Carter
 * -Only of outputData() and adding outputData() to the main method.   The first part of the
 * code was provided by the assignment.
 *
 * This program uses ObjectOutputStream to save Loan objects to a file, and then a method
 * is used to read them from the file, regardless of the file's size.
 */

import java.io.*;
import java.util.ArrayList;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }

        outputData();
    }

    public static void outputData() {
        ArrayList<Loan> loanList = new ArrayList<>();
        try (
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"))
        ) {
            while (true) {
                try {
                    Loan loan = (Loan) input.readObject();
                    loanList.add(loan);
                }
                catch (EOFException eof) {
                    break;
                }
            }
        }
        catch (IOException ex) {
            System.out.println("File could not be opened");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for(int i = 0; i < loanList.size(); i++) {
            System.out.print("Loan "+ (i+1) + ", total loan amount: $");
            System.out.printf("%.2f\n", loanList.get(i).getLoanAmount());
        }
        double totalLoanAmount = 0;
        for (Loan loan : loanList) {
            totalLoanAmount += loan.getLoanAmount();
        }
        System.out.printf("Sum total of loans amount: $%.2f\n", totalLoanAmount);

    }
}
