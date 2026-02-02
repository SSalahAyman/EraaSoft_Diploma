package Task5;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Task5 {
    public static void main(String[] args)  {
        try{
            FileReader reader=new FileReader("hello.txt"); // >>> this line throw FileNotFoundException
        }
        // So, we handle the FileNotFoundException with this catch with print Statement "File not found" instead of crash the program
        catch (FileNotFoundException e ){
            System.out.println("File not found: Please check the file path");
        }
    }
}
