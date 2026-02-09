package OptionalAndMapAndFlatMapTasks;

import java.awt.geom.RectangularShape;
import java.util.*;
import java.util.stream.Collectors;

public class OptionalAndMapAndFlatMap {
    public static void main(String[] args) {
        List<List<String>> nestedWords = Arrays.asList(
                Arrays.asList("Java", "Stream"),
                Arrays.asList("API", "Lambda"),
                Arrays.asList("FlatMap", "Map")
        );
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
        /********************************************************** Task (1) *****************************************************************/
        // (1) Flatten a list of lists into a single list.
        List<String> newListWithFlat=nestedWords.stream().flatMap(list->list.stream()).collect(Collectors.toList());
        System.out.println("the new list after flatten is : "+newListWithFlat);

        /********************************************************** Task (2) *****************************************************************/
        // (2) Extract all unique characters from a list of words.
        // before doing flatten , we do filter remove any null & " " from
        Set<Character> uniqueChars=names.stream().filter(name->name!=null && !name.isEmpty()).flatMap(name->
             name.chars().mapToObj(c -> (char)c)  // to convert every name to stream<Character>
        ).collect(Collectors.toSet()); // here collect all streamChar into a set & remove anyDuplicated character
        System.out.println(uniqueChars);

        /********************************************************** Task (3) *****************************************************************/
        // (3) Filter a list of Optionals and collect non-empty values.
        List<Optional<String>> optionalList = Arrays.asList(
                Optional.of("Java"),
                Optional.empty(),
                Optional.of("Stream"),
                Optional.of("Lambda"),
                Optional.empty()
        );
        // Filter non-empty Optionals and collect values
        List<String> nonEmptyValues = optionalList.stream()
                .filter(v->v.isPresent())
                .map(v->v.get())                    // نحصل على القيمة داخل الـ Optional
                .collect(Collectors.toList());         // نجمعهم في List
        System.out.println(nonEmptyValues);

        /********************************************************** Task (4) *****************************************************************/
        // (4) Map a list of strings to their lengths.
        // before map , we use filter to ignore null value
        List<Integer> lengths = names.stream().filter(name -> name != null).map(name -> name.length()).collect(Collectors.toList());
        System.out.println("the length of each string in the list : "+lengths);

        /********************************************************** Task (5) *****************************************************************/
        // (5) Return a list of uppercased words that start with “A”.
        List<String> result = names.stream()
                .filter(name -> name != null && !name.isEmpty()).filter(name -> name.startsWith("A")).
                map(name -> name.toUpperCase()).collect(Collectors.toList());
        System.out.println("the new list with uppercase words starts with A : "+ result);

    }
}
