package Task9;

public class Task9 {
    // this method throw an ArithmeticException
    static void divide() {
        int a = 10;
        int b = 0;
        int result = a / b;   // >>> this line throw ArithmeticException
    }
    // this method call another method without handling the exception from the Invoked method
    static void calculate() {
        divide();   // Exception propagates from divide()
    }
    // the main method call calculate() and catch exception from calling , and handle it
    public static void main(String[] args) {
        try{
            calculate();
        }catch (ArithmeticException e){
            System.out.println("Error: Division by zero");
        }
    }
}
