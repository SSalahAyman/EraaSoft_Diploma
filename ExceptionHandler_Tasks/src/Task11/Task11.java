package Task11;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("enter your first num : ");
        double firstNum=input.nextInt();
        System.out.println("enter your second num : ");
        double secondNum=input.nextInt();
        try {
            double result =firstNum /secondNum;   // >>> this line can be throw ArithmeticException if secondNum=0
            System.out.println("your result is : "+result);
        }
        // here I use catch to catch another type of exception not the ArithmeticException
        catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Division by zero");
        }
        /* the finally block is always executes the user enter the correct two numbers to divide it & also executed when the program
        is crash with exception because of ArithmeticException , and continues executes statement of finally block
         */
        finally {
            System.out.println("you can enter new two numbers to divide again ");
        }

        /*
        [first case] :-
        firstNum >>> 1
        second Num >>> 2
        result is 0,5 ✅
        you can enter new two numbers to divide again [the statement of finally is also executed] ✅
         */

        /*
        [second case] :-
        firstNum >>> 1
        second Num >>> 0
        result is throw  ArithmeticException , & program crash❌
        you can enter new two numbers to divide again [the statement of finally is also executed ,even after the program is crashed] ✅
         */
    }
}
