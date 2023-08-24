import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorTester {
    public static void main(String[] args) {
        calculatorRunning();
    }









    public static void calculatorRunning() {
        CalculatorOperations calculator = new CalculatorOperations();
        MatrixOperations matrixCalculator = new MatrixOperations();
        Scanner input = new Scanner(System.in);
        boolean programRunning = true;
        long startTime = System.currentTimeMillis();
        while (programRunning) {
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.println("Welcome to the Calculator App, What would you like to do?");
            System.out.println("1 - Add\n2 - Subtract\n3 - Division\n4 - Multiply\n5 - Maximum\n6 - Minimum\n7 - Absolute Value\n" +
                    "8 - Decimal to Binary\n9 - Decimal to Octal\n10 - Decimal to Hexadecimal\n11 - Quit Program\n12 - Perform Matrix Operations (includes adding, subtracting, multiplying, dividing matrices, and much more...");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            try {
                int choice = input.nextInt();
                calculator.choose(choice);
                if (choice == 11) { // exit program
                    programRunning = false;
                }
                if (choice == 12) {
                    matrixCalculator.running();
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR - Do not input strings and PLEASE READ THE DIRECTIONS!");
                input.nextLine();
            }
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("You've been using the Calculator App for " + (stopTime - startTime) + " ms");
        input.close();
    }



}







