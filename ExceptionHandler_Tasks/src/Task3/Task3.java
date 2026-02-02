package Task3;

public class Task3 {
    // this method is used to convert any input small case letters to upper case by passing the string to the method as a parameters
    public static String toConvertUpperCase(String input){
        input=input.toUpperCase();
        return input;
    }
    public static void main(String[] args) {
        String input = null;
        try {
            // here we pass a null to the parameter method so ,it throws NullPointerException
            String newForm=toConvertUpperCase(input);
            System.out.println(newForm);
        }
        catch (NullPointerException e){
            System.out.println("Invalid input: string is null");
        }

    }
}
