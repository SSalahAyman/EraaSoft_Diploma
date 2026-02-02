package Task10;
import java.io.FileReader;
import java.io.IOException;

public class Task10 {
    static void readFile() throws IOException {
        FileReader reader=new FileReader("test.txt");
        reader.read();   // read a character from file
        reader.close();
    }
    public static void main(String[] args) {
        try {
            readFile();     // calling the method
            System.out.println("File read successfully");
        } catch (IOException e) {
            System.out.println("Error: Unable to read the file");
        }
    }
}
