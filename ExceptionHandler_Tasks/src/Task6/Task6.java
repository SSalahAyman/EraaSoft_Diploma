package Task6;

public class Task6 {
    public static void main(String[] args) {
        String in=null;
        int firstNumber=10;
        int secondNumber=0;
        try{
            System.out.println(in.toUpperCase());  // >>> this line throw Null pointerException
        }
        // So, we handle the Null pointer Exception with this catch with print Statement "Error" instead of crash the program
        catch (NullPointerException e){
            System.out.println("Error Null reference used");
        }
        try {
            int result;
            result=firstNumber/secondNumber;  // >>> this line throw ArithmeticException
            System.out.println(result);
        }
        // So, we handle the ArithmeticException with this catch with print Statement "Error" instead of crash the program
        catch (ArithmeticException e){
            System.out.println("Error Division by zero");
        }
    }
}
