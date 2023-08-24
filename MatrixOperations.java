import java.util.Scanner;
import java.util.InputMismatchException;

public class MatrixOperations{

    public void running() {
        Scanner input = new Scanner(System.in);
        System.out.println("You will be able to create two matrices (A & B)");
        System.out.println("Enter rows for Matrix A");
        int rowA = input.nextInt();
        while(rowA <= 0){
            System.out.println("Cannot have rows with negative numbers or with decimals, ONLY INTEGERS.");
            System.out.println("Enter rows for Matrix A");
            rowA = input.nextInt();
        }
        System.out.println("Enter columns for Matrix A");
        int columnA = input.nextInt();
        while(columnA <= 0){
            System.out.println("Cannot have columns with negative numbers or with decimals, ONLY INTEGERS");
            System.out.println("Enter columns for Matrix A");
            columnA = input.nextInt();
        }
        int[][] matrixA = inputMatrix(rowA, columnA);

        System.out.println("Enter rows for Matrix B");
        int rowB = input.nextInt();
        while(rowB <= 0){
            System.out.println("Cannot have rows with negative numbers or with decimals, ONLY INTEGERS.");
            System.out.println("Enter rows for Matrix B");
            rowB = input.nextInt();
        }
        System.out.println("Enter columns for Matrix B");
        int columnB = input.nextInt();
        while(columnB <= 0){
            System.out.println("Cannot have columns with negative numbers or with decimals, ONLY INTEGERS");
            System.out.println("Enter columns for Matrix B");
            columnB = input.nextInt();
        }

        int[][] matrixB = inputMatrix(rowB, columnB);

        inputMatrixANumbers(matrixA);
        inputMatrixBNumbers(matrixB);

        boolean programRunning = true;

        while (programRunning) {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("What would you like to do with the Matrices?");
            displayMatrixA(matrixA);
            displayMatrixB(matrixB);
            System.out.println("1 - Add Matrices, 2 - Subtract Matrices, 3 - Multiply Matrices\n 4 - Transpose Matrices, 5 - Join Matrices, 6 - Return to Operations Calculator");
            System.out.println("----------------------------------------------------------------------------------------");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    addMatrices(matrixA, matrixB, rowA, columnA, rowB, columnB);
                    break;
                case 2:
                    subtractMatrices(matrixA, matrixB, rowA, columnA, rowB, columnB);
                case 3:
                    displayMultiplyedMatrix(multiplyMatrices(matrixA, matrixB, rowA, columnA, rowB, columnB));
                case 4:
                    System.out.println("Transposed Matrix A");
                    transposeMatrix(matrixA);
                    System.out.println("Transposed Matrix B");
                    transposeMatrix(matrixB);
                case 5:
                    if (testMatrices(matrixA, matrixB, rowA, columnA, rowB, columnB) == 1) {
                        System.out.println("Joining Matrices...");
                        displayJoinedMatrix(joinMatrices(matrixA, matrixB, rowA, columnA, rowB, columnB));
                    }
                case 6:
                    programRunning = false;
                    System.out.println("Reverting back to Operations Calculator...");
                default:
                    System.out.println("Choose one of the available options.");
            }
        }
    }

    public void displayMultiplyedMatrix(int[][] matrix) {
        Scanner input = new Scanner(System.in);
        System.out.println("Multiplied Matrix:");
        for (int row = 0; row < matrix.length; row++) {
            System.out.print("[ ");
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + "\t");
            }
            System.out.println("]");
        }
        System.out.println();
    }

    public void displayJoinedMatrix(int[][] matrix) {
        Scanner input = new Scanner(System.in);
        System.out.println("Joined Matrix:");
        for (int row = 0; row < matrix.length; row++) {
            System.out.print("[ ");
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + "\t");
            }
            System.out.println("]");
        }
        System.out.println();
    }

    public int[][] inputMatrix(int row, int column) {
        int[][] matrix = new int[row][column];
        return matrix;
    }

    public int[][] inputMatrixANumbers(int[][] matrix) {
        Scanner input = new Scanner(System.in);
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.println("Input number for Matrix A in row " + (row + 1) + ", column " + (column + 1));
                int number = input.nextInt();
                matrix[row][column] = number;
            }
        }
        return matrix;
    }

    public int[][] inputMatrixBNumbers(int[][] matrix) {
        Scanner input = new Scanner(System.in);
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.println("Input number for Matrix B in row " + (row + 1) + ", column " + (column + 1));
                int number = input.nextInt();
                matrix[row][column] = number;
            }
        }
        return matrix;
    }

    public void displayMatrixA(int[][] matrix) {
        Scanner input = new Scanner(System.in);
        System.out.println("Matrix A:");
        for (int row = 0; row < matrix.length; row++) {
            System.out.print("[ ");
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + "\t");

            }
            System.out.println("]");
        }
        System.out.println();
    }


    public void displayMatrixB(int[][] matrix) {
        Scanner input = new Scanner(System.in);
        System.out.println("Matrix B:");
        for (int row = 0; row < matrix.length; row++) {
            System.out.print("[ ");
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + "\t");
            }
            System.out.println("]");
        }
        System.out.println();
    }

    public int[][] multiplyMatrices(int[][] a, int[][] b, int rowA, int columnA, int rowB, int columnB) { // only works with 1x1 and 2x2
        int[][] newMatrix = new int[rowA][columnB];
        if (columnA == rowB) {
            System.out.println("Multiplying...");
            for (int row = 0; row < a.length; row++) {
                for (int column2 = 0; column2 < columnB; column2++) {
                    int previousTerm = 0;
                    for (int column = 0; column < a[row].length; column++) {
                        // starts in the first column
                        int currentTerm = a[row][column] * b[column][column2];
                        previousTerm = currentTerm;
                        newMatrix[row][column2] = newMatrix[row][column2] + previousTerm;
                        System.out.println((row + 1) + "*" + (column + 1) + " = " + a[row][column] + " | " + (column + 1) + "*" + (column2 + 1) + " = " + b[column][column2] + " | " + previousTerm);
                    }
                }
            }
        } else {
            System.out.println("Columns or/and rows do not match, cannot perform operation.");
        }
        return newMatrix;
    }

    public void addMatrices(int[][] a, int[][] b, int rowA, int columnA, int rowB, int columnB) {
        if (columnA == columnB) {
            if (rowA == rowB) {
                System.out.println("Adding...");
                System.out.println("Added Matrix (Matrix A + Matrix B):");
                for (int row = 0; row < a.length; row++) {
                    System.out.print("[ ");
                    for (int column = 0; column < a[row].length; column++) {
                        System.out.print(a[row][column] + b[row][column] + "\t");
                    }
                    System.out.println("]");
                }
                System.out.println();
            } else {
                System.out.println("Columns or/and rows do not match, cannot perform operation.");
            }
        } else {
            System.out.println("Columns or/and rows do not match, cannot perform operation.");
        }
    }

    public void subtractMatrices(int[][] a, int[][] b, int rowA, int columnA, int rowB, int columnB) {
        if (columnA == columnB) {
            if (rowA == rowB) {
                System.out.println("Subtracting...");
                System.out.println("Subtracted Matrix (Matrix A - Matrix B):");
                for (int row = 0; row < a.length; row++) {
                    System.out.print("[ ");
                    for (int column = 0; column < a[row].length; column++) {
                        System.out.print(a[row][column] - b[row][column] + "\t");
                    }
                    System.out.println("]");
                }
                System.out.println();
            } else {
                System.out.println("Columns or/and rows do not match, cannot perform operation.");
            }
        } else {
            System.out.println("Columns or/and rows do not match, cannot perform operation.");
        }
    }

    public void transposeMatrix(int[][] matrix) {
        Scanner input = new Scanner(System.in);
        for (int row = 0; row < matrix.length; row++) {
            System.out.print("[ ");
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[column][row] + "\t");
            }
            System.out.println("]");
        }
        System.out.println();
    }

    public int testMatrices(int[][] matrixA, int[][] matrixB, int rowA, int columnA, int rowB, int columnB) {
        if (!(columnA == columnB) || !(rowA == rowB)) {
            System.out.println("The columns or/and rows of both matrices do not match.");
            return -1;
        }
        for (int row = 0; row < matrixA.length; row++) { // checks matrix A for zeros and ones
            for (int column = 0; column < matrixA[row].length; column++) {
                int checkZeroAndOnes = matrixA[row][column];
                if (checkZeroAndOnes != 0) {
                    if (checkZeroAndOnes != 1) {
                        System.out.println("Matrix does not have all 0s and 1s");
                        return -1;
                    }
                }
            }
        }
        for (int row = 0; row < matrixB.length; row++) { // checks matrix B for zeros and ones
            for (int column = 0; column < matrixB[row].length; column++) {
                int checkZerosandOnes = matrixB[row][column];
                if (checkZerosandOnes != 0) {
                    if (checkZerosandOnes != 1) {
                        System.out.println("Matrix does not have all 0s and 1s");
                        return -1;
                    }
                }
            }
        }
        return 1;
    }

    public int[][] joinMatrices(int[][] matrixA, int[][] matrixB, int rowA, int columnA, int rowB, int columnB) {
        int[][] joinedMatrix = new int[rowA][columnA];
        for (int row = 0; row < matrixB.length; row++) { // checks matrix B for zeros and ones
            for (int column = 0; column < matrixB[row].length; column++) {
                if(matrixA[row][column] == 1){
                    if(matrixB[row][column] == 1){
                        joinedMatrix[row][column] = 1;
                    }
                    if(matrixB[row][column] == 0){
                        joinedMatrix[row][column] = 1;
                    }
                }
                if(matrixA[row][column] == 0){
                    if(matrixB[row][column] == 1){
                        joinedMatrix[row][column] = 1;
                    }
                    if(matrixB[row][column] == 0){
                        joinedMatrix[row][column] = 0;
                    }
                }
            }
        }
        return joinedMatrix;
    }

}





