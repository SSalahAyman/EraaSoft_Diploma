package Task7;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("enter your age : ");
        int age=input.nextInt();
        try{
            if (age<18){
                // here the program throw this custom exception if ageInput <18 ,
                throw new InvaildAgeException("Error your age is under 18");
            }
        }
        // and we handle this custom exception with catch statement with only print the message of the exception instead of crash the program
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
