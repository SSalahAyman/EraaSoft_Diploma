package NumericStreamsReductions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class NumericStreamsReductions {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        /********************************************************** Task (1) *****************************************************************/
        // (1) Calculate the sum of a list of integers using reduce.
        Optional<Integer>sumOfNumbers=numbers.stream().reduce((a,b)->a+b);
        if (sumOfNumbers.isPresent()) // here handle cases where the stream might be empty, preventing NullPointerException if the element is not found.
            System.out.println("the first odd number is : "+sumOfNumbers.get()); // "sum of numbers is 60 "
        else
            System.out.println("the list is empty");

        /********************************************************** Task (2) *****************************************************************/
        // (2) Find the maximum and minimum value in a list.
        int maxNumber=numbers.stream().max((value,max)->value.compareTo(max)).get();
        System.out.println("the max maximum number in the list is : "+maxNumber);  // 10

        int minimumNumber=numbers.stream().min((value,min)->value.compareTo(min)).get();
        System.out.println("the max maximum number in the list is : "+minimumNumber); // -3

        /********************************************************** Task (3) *****************************************************************/
        // (3) Calculate the average of a list of doubles.
        // we need to work on the list of double so ,before use average() , I use mapToDouble() to convert each element to double & return a new stream of double numbers
        OptionalDouble avg =numbers.stream().mapToDouble(value->value).average();
        System.out.println("the average of a list of doubles is : "+avg.orElse(0)); // (5.0) , if list is empty return 0 ,insteadof throw Exception

        /********************************************************** Task (4) *****************************************************************/
        // (4) Multiply all integers in a list together using reduce.
        Optional<Integer>Multiplication=numbers.stream().reduce((a,b)->a*b);
        if (Multiplication.isPresent())
            System.out.println("your multiplication of all elements in the list : "+Multiplication.get());  // (0) the result of Multiplication all numbers together
        else
            System.out.println("The list is empty");

        /********************************************************** Task (5) *****************************************************************/
        // (5) Count how many numbers are positive in a list.
        long numberOfPositiveNumbers= numbers.stream().filter(value->value>0).count();
        System.out.println("the number of positive numbers is "+ numberOfPositiveNumbers);  // (10) positive number in a list
    }
}
