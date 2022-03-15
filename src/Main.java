import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два числа:");
        String userInput = "";

        while (!"q".equals(userInput)) {
            try{
            int firstNumber = scanner.nextInt();
            int secondNumber = scanner.nextInt();
            userInput = scanner.nextLine();

            double result;

            switch (userInput){
                case "+":
                    result = plus(firstNumber, secondNumber);
                    break;
                case "-":
                    result = minus(firstNumber, secondNumber);
                    break;
                case "*":
                    result = ymn(firstNumber, secondNumber);
                    break;
                case "/":
                    if(secondNumber == 0){
                        continue;
                    }
                    result = del(firstNumber, secondNumber);
                    break;
                case "!":
                    result = fact(firstNumber);
                    break;
                default:
                    result = 0;
                    break;
            }
                System.out.println(result);
            } catch (InputMismatchException ex){
                System.out.println("Wrong input data!");
                continue;
            }
        }
    }

    private static int plus(int numberOne, int numberTwo){
        return numberOne + numberTwo;
    }
    private static int minus(int numberOne, int numberTwo){
        return numberOne - numberTwo;
    }

    private static int ymn(int numberOne, int numberTwo){
        return numberOne * numberTwo;
    }

    private static int del(int numberOne, int numberTwo){
        return numberOne / numberTwo;
    }

    private static int fact(int numberOne){
        int res = 1;
        for (int i = 1; i < numberOne; i++) {
            res *= i;
        }

        return res;


    }

}

/*
public class Calculator {
    public static void main(String[] args) {

        float firstNumber, secondNumber;
        String operation;

        Scanner input = new Scanner(System.in);

        System.out.println("Введите ниже первое число! ...");
        firstNumber = input.nextFloat();

        System.out.println("Введите ниже второе число! ...");
        secondNumber = input.nextFloat();

        Scanner op = new Scanner(System.in);

        System.out.println("Введите операцию (Возможные варианты: +, -, /, *)");
        operation = op.next();


        switch (operation) {
            case "+":

                System.out.println("Ответ: " + (firstNumber + secondNumber));
                break;

            case "-":
                System.out.println("Ответ: " + (firstNumber - secondNumber));
                break;

            case "/":
                if (secondNumber == 0) {
                    System.out.println("На 0 делить нельзя !!!");
                    break;
                }
*/


package ru.luxoft.cources;

        import java.util.InputMismatchException;
        import java.util.Scanner;

//W -> R -> F
//1. Do it work
//2. Do it right
//3. Do it fast

public class Calculator {
    private String userInput;
    private Scanner scanner;

    public Calculator() {
        this.scanner = new Scanner(System.in);
    }

    public void calculationProcess(){
        while (!"q".equals(userInput)) {
            try {
                System.out.println(calculationStep());
            } catch (InputMismatchException ex){
                System.out.println("Wrong input data!");
                continue;
            } catch (DivideByZeroException e) {
                System.out.println("Wrong second number for divide");
                continue;
            }
        }
    }

    private double calculationStep() throws DivideByZeroException, InputMismatchException {
        int firstNumber = inputNumber( 0);
        int secondNumber = inputNumber( 0);

        userInput = scanner.nextLine();

        return calculate(firstNumber, secondNumber);
    }

    private double calculate(int firstNumber, int secondNumber) throws DivideByZeroException {
        double result;

        switch (userInput){
            case "+":
                result = plus(firstNumber, secondNumber);
                break;
            case "-":
                result = minus(firstNumber, secondNumber);
                break;
            case "*":
                result = ymn(firstNumber, secondNumber);
                break;
            case "/":
                if(secondNumber == 0){
                    throw new DivideByZeroException();
                }
                result = del(firstNumber, secondNumber);
                break;
            case "!":
                result = fact(firstNumber);
                break;
            default:
                result = 0;
                break;
        }

        return result;
    }

    private int plus(int numberOne, int numberTwo){
        return numberOne + numberTwo;
    }

    private int minus(int numberOne, int numberTwo){
        return numberOne - numberTwo;
    }

    private int ymn(int numberOne, int numberTwo){
        return numberOne * numberTwo;
    }

    private int del(int numberOne, int numberTwo){
        return numberOne / numberTwo;
    }

    private int fact(int numberOne){
        int res = 1;
        for (int i = 1; i < numberOne; i++) {
            res *= i;
        }

        return res;
    }

    private int inputNumber(int retries){
        int result = 0;
        try {
            result = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException inex){
            if(retries < 3) {
                result = inputNumber(++retries);
            } else {
                throw new IllegalArgumentException("Wrong input number");
            }
        }
        return result;
    }
}