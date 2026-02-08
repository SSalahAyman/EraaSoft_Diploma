package BasicStreamOperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BasicStreamOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
        /********************************************************** Task (1) *****************************************************************/
        // (1) Filter even numbers from a list of integers.
        List<Integer> evenNumbers=numbers.stream().filter(value->value%2==0).toList();
        System.out.println("your list after filtering is : "+evenNumbers);

        /********************************************************** Task (2) *****************************************************************/
        // (2) Find names starting with a specific letter from a list of strings.
        /*
        - First we must remove null before filter to prevent NullPointerException ,So before doing filter names that starts with specific letter "A" ,
         First I filter a list without null >>> then doing Filtering
         */
        List<String>namesStartWithA=names.stream().filter(name->name!=null).filter(name->name.startsWith("A")).toList();
        System.out.println("the names that starts with A : "+namesStartWithA);

        /********************************************************** Task (3) *****************************************************************/
        // (3) Convert all strings to uppercase using stream.
        /*
        - First we must remove null before filter to prevent NullPointerException ,So before converting to uppercase I filter a list
          without null & " " >>> then doing convert by map
         */
        List<String>upperCaseStrings=names.stream().filter(name->name!=null && !name.isEmpty()).map(name->name.toUpperCase()).toList();
        System.out.println("your list after convert all elements to upper is : "+upperCaseStrings);

        /********************************************************** Task (4) *****************************************************************/
        // (4) Sort a list of integers in descending order using streams.
        List<Integer> descendingIntegers =numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("your numbers after being sorted in descending order : "+descendingIntegers);

        /********************************************************** Task (5) *****************************************************************/
        // (5) Remove duplicate elements from a list using distinct().
        List<Integer> uniqueNumbers=numbers.stream().distinct().toList();
        System.out.println("your list with unique numbers only is : "+uniqueNumbers);
    }
}
