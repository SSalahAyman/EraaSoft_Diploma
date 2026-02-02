package Task2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("please enter your StringNumber to give to you as IntegerNumber form : ");
        /*
        here we put this two lines in try block because it can throw exception of type NumberFormat exception when user enter a valid
        format of number such as "123a , null, twenty, ..." this cases cannot convert it to Integer Number form
         */
        try {
            String stringForm= input.nextLine();
            int numberForm=Integer.parseInt(stringForm);
            System.out.println("your input "+numberForm+" is converted sucessfully as number form");
        }
        /* we solve this issue by put catch block if this cases happened by when the program catches this exception , print a certain
        message instead of crashing the program
         */
        catch (NumberFormatException e){
            System.out.println("Please enter a valid number");
        }
    }
}
