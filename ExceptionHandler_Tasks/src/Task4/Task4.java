package Task4;
import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter your 5 elements of your array ");
        int limit0fArray=5;
        int[]arr=new int[limit0fArray];
        // this for loop is used to create array of five elements integer by user that input it
        for (int index=0;index<arr.length;index++){
            System.out.println("please enter the element of index "+index +" :");
            arr[index]=input.nextInt();
        }
        System.out.println(Arrays.toString(arr));  // >>> this line is used to print the elements of array that you input it

        System.out.println("Enter certain index to access element from your input array : ");
        try{
            // here this line the user can enter index but, it can out of array bounds so it can crash program and produce ArrayIndexOutOfBounds Exception
            int inputIndex=input.nextInt();
            System.out.println("The element of index "+inputIndex+" is "+arr[inputIndex]);
        }
        // So , we handle this exception with catch block & Put a statement that shows for user your index is Invalid
        catch (IndexOutOfBoundsException e){
            System.out.println("Invalid index because it's out of array bounds");
        }
    }
}
