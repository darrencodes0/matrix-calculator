import java.util.ArrayList;
import java.util.Scanner;


public class CalculatorOperations {

    ArrayList<Double> doubleArrayList = new ArrayList<>();
    ArrayList<Integer> integerArrayList = new ArrayList<>();

    // calculator operations (Below)

    public void add() {
        double sum = 0;
        for (double numbers : doubleArrayList) {
            sum = sum + numbers;
        }
        System.out.println("Sum: " + sum);
    }

    public void multiply() {
        double result = 1;
        for (double numbers : doubleArrayList) {
            result = result * numbers;
        }
        System.out.println("Result: " + result);
    }

    public void division(){
        double result = 1;
        for(double numbers : doubleArrayList){
            result = result / numbers;
        }
        System.out.println("Result: " + result);
    }

    public void subtract(double beginningValue) {
        double result = beginningValue; // sets the first value onto result FIRST
        for (double numbers : doubleArrayList) {
            result = result - numbers;
        }
        System.out.println("Result: " + result);
    }

    public void max() {
        double maxNum = -999999999;
        for (double number : doubleArrayList) {
            if (number > maxNum) {
                maxNum = number;
            }
        }
        System.out.println("Maximum: " + maxNum);
    }

    public void min() {
        double lowestNum = 999999999;
        for (double number : doubleArrayList) {
            if (number < lowestNum) {
                lowestNum = number;
            }
        }
        System.out.println("Minimum: " + lowestNum);
    }

    public void absoluteValue(double number){
        double absoluteNum;
        if(number < 0){
            absoluteNum = number * -1;
        } else{
            absoluteNum = number;
        }
        System.out.println("|" + number + "|: " + absoluteNum);
    }

    public void convertDecimalToBinary(int number){
        boolean negative = false;
        boolean positive = false;

            while(number > 0) { // positive value
                int result = number % 2;
                number = number / 2;
                integerArrayList.add(result);
                positive = true;
            }
        while(number < 0) { // negative value
            int result = number % 2;
            number = number / 2;
            integerArrayList.add(result);
            negative = true;
        }
            System.out.print("Binary: ");
            if(negative){
                System.out.print("-");
                for (int i = integerArrayList.size() - 1; i > -1; i--) {
                    System.out.print(-1 * integerArrayList.get(i));
                }
                System.out.println("\t");
            }
            if(positive) {
                for (int i = integerArrayList.size() - 1; i > -1; i--) {
                    System.out.print(integerArrayList.get(i));
                }
                System.out.println("\t");
            }
    }

    public void convertDecimalToOcto(int number){
        boolean negative = false;
        boolean positive = false;
        while(number > 0) {
            int result = number % 8;
            number = number / 8;
            integerArrayList.add(result);
            positive = true;
        }
        while(number < 0) {
            int result = number % 8;
            number = number / 8;
            integerArrayList.add(result);
            negative = true;
        }
        System.out.print("Octo: ");
        if(negative){
            System.out.print("-");
            for (int i = integerArrayList.size() - 1; i > -1; i--) {
                System.out.print(-1 * integerArrayList.get(i));
            }
            System.out.println("\t");
        }
        if(positive) {
            for (int i = integerArrayList.size() - 1; i > -1; i--) {
                System.out.print(integerArrayList.get(i));
            }
            System.out.println("\t");
        }
}

    public void convertDecimalToHexa(int number){
        boolean positive = false;
        boolean negative = false;
        while(number > 0) {
            int result = number % 16;
            number = number / 16;
            integerArrayList.add(result);
            positive = true;
        }
        while(number < 0) {
            int result = number % 16;
            number = number / 16;
            integerArrayList.add(result);
            negative = true;
        }
        System.out.print("Hexadecimal: ");
        if (positive) {
            for (int i = integerArrayList.size() - 1; i > -1; i--) {
                double hexadecimal = integerArrayList.get(i);
                if (hexadecimal >= 10) {
                    switch ((int)hexadecimal) {
                        case 10:
                            System.out.print("A");
                            break;
                        case 11:
                            System.out.print("B");
                            break;
                        case 12:
                            System.out.print("C");
                            break;
                        case 13:
                            System.out.print("D");
                            break;
                        case 14:
                            System.out.print("E");
                            break;
                        case 15:
                            System.out.print("F");
                            break;
                    }
                } else {
                    System.out.print(integerArrayList.get(i));
                }
            }
            System.out.println("\t");
        }
        if (negative) {
            System.out.print("-");
            for (int i = integerArrayList.size() - 1; i > -1; i--) {
                int hexadecimal = integerArrayList.get(i);
                if (hexadecimal <= -10) {
                    switch ((int)hexadecimal) {
                        case -10:
                            System.out.print("A");
                            break;
                        case -11:
                            System.out.print("B");
                            break;
                        case -12:
                            System.out.print("C");
                            break;
                        case -13:
                            System.out.print("D");
                            break;
                        case -14:
                            System.out.print("E");
                            break;
                        case -15:
                            System.out.print("F");
                            break;
                    }
                } else {
                    System.out.print(-1 * integerArrayList.get(i));
                }
            }
            System.out.println("\t");
        }
    }

    // making the calculator work

    public void choose(int answer) {
        Scanner input = new Scanner(System.in);
        switch (answer) {

            case 1:
                storingNumbers();
                add();
                break;

            case 2:
                int inputs = 0;
                double startingValue = 0;
                boolean positiveInput = false;

                while(!positiveInput) {
                    System.out.println("How many numbers are you putting in?");
                    inputs = input.nextInt();
                    if(inputs <= 0) {
                        System.out.println("Cannot have negative amount of numbers.");
                    }
                    if(inputs > 0){
                        positiveInput = true;
                    }
                    }
                if(positiveInput) {
                    System.out.println("What is the starting number to be subtracted?");
                    startingValue = input.nextDouble();
                    for (int i = 0; i < inputs - 1; i++) {
                        System.out.println("Input Number " + (i + 1));
                        double inputtedNumber = input.nextDouble();
                        doubleArrayList.add(inputtedNumber);
                    }
                }
                subtract(startingValue);
                break;

            case 3:
                storingNumbers();
                division();
                break;

            case 4:
                storingNumbers();
                multiply();
                break;


            case 5:
                storingNumbers();
                max();
                break;

            case 6:
                storingNumbers();
                min();
                break;

            case 7:
                absoluteValue(inputDoubleOneValue());
                break;

            case 8:
                System.out.println("NO DOUBLE VALUES, ONLY INTEGERS!");
                convertDecimalToBinary(inputIntegerOneValue());
                break;

            case 9:
                System.out.println("NO DOUBLE VALUES, ONLY INTEGERS!");
                convertDecimalToOcto(inputIntegerOneValue());
                break;

            case 10:
                System.out.println("NO DOUBLE VALUES, ONLY INTEGERS!");
                convertDecimalToHexa(inputIntegerOneValue());
                break;
            case 11:
                System.out.println("Goodbye!");
                break;
            case 12:
                System.out.println("Changing to Matrix Calculator...");
                break;
            default:
                System.out.println("Choice not avaliable, pick another one");
        }
        doubleArrayList.clear();
        integerArrayList.clear();
    }

    public void storingNumbers() {
        int inputs = 0;
        boolean positiveInput = false;
        Scanner input = new Scanner(System.in);
        while(!positiveInput) {
            System.out.println("How many numbers are you putting in?");
            inputs = input.nextInt();
            if (inputs <= 0) {
                System.out.println("Cannot have a negative amount of numbers.");
            }
            if (inputs > 0) {
                positiveInput = true;
            }
        }
        if(positiveInput) {
            for (int i = 0; i < inputs; i++) {
                System.out.println("Input Number " + (i + 1));
                double inputtedNumber = input.nextDouble();
                integerArrayList.add((int) inputtedNumber);
                doubleArrayList.add(inputtedNumber);
            }
        }
    }

    public double inputDoubleOneValue(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the number?");
        double number = input.nextDouble();
        return number;
    }

    public int inputIntegerOneValue(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the number?");
        int number = input.nextInt();
        return number;
    }




























































}


