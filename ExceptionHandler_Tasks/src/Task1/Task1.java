package Task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter your first number : ");
        int firstNum = input.nextInt();
        System.out.println("please enter your second number : ");
        int secondNum = input.nextInt();
        int result;
        try {
            // this line can throw exception of type ArithmeticException ,So we put this line at try block
            result = firstNum / secondNum;
            System.out.println("your result is : "+result);
        }
        /* here we give to the try block a catch block to this line to catch any type of Exception that appear at Run-time & cause
        crash program so instead of this crash the program print a certain message of the Invalid input number
         */
        catch (Exception e) {
            System.out.println("Invalid Second num because cannot divide by zero");
        }
    }
}
