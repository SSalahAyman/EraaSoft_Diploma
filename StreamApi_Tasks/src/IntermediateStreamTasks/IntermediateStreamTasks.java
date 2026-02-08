package IntermediateStreamTasks;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class IntermediateStreamTasks {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
        /********************************************************** Task (1) *****************************************************************/
        // (1) Count the number of strings longer than 5 characters
        Long countOfStrings =names.stream().filter(name->name!=null).filter(name->name.length()>5).count();
        System.out.println(countOfStrings); // 1 ("Kareem" only because it has 6 characters)

        /********************************************************** Task (2) *****************************************************************/
        // (2) Find the first element in a stream that matches a given condition.
        Optional<Integer>firstOdd=numbers.stream().filter(number->number%2!=0).findFirst();   // List of odd Numbers: [5,3,7,5,9,-3] , "First odd number is 5 "
        if (firstOdd.isPresent()) // here handle cases where the stream might be empty, preventing NullPointerException if the element is not found.
            System.out.println("the first odd number is : "+firstOdd.get()); // "First odd number is 5 "
        else
            System.out.println("the list is empty");

        /********************************************************** Task (3) *****************************************************************/
        // (3) Check if any number is divisible by 5 in a list.
        Boolean result =numbers.stream().anyMatch(number-> number%5==0);
        System.out.println(result); // true (that means there are numbers divisible by 5 >>> "5,10,0")

        /********************************************************** Task (4) *****************************************************************/
        // (4) Collect elements into a Set instead of a List.
        Set<Integer> setNumbers=numbers.stream().collect(Collectors.toSet());
        System.out.println(setNumbers);

        /********************************************************** Task (5) *****************************************************************/
        // (5) Skip the first 3 elements and return the rest.
        List<Integer> newListAfterSkip= numbers.stream().skip(3).collect(Collectors.toList());
        System.out.println("the new list after skipping first 3 elements : "+newListAfterSkip);
    }
}
