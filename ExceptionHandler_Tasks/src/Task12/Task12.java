package Task12;

public class Task12 {
    public static void main(String[] args) {
        try {   //  Outer try
            System.out.println("Outer try started");
            try {   //  Inner try that causes the ArithmeticException from dividing by Zero
                int a = 10;
                int b = 0;
                int result = a / b;   //  ArithmeticException
                System.out.println(result);

            } catch (NullPointerException e) {  // Inner catch
                System.out.println("Error: NullPointerException");
            }
            System.out.println("Outer try continues");
        } catch (ArithmeticException e) {   // outer catch that catches the ArithmeticException that thrown from the divison by zero
            System.out.println("Error: Division by zero");
        }
    }
}
