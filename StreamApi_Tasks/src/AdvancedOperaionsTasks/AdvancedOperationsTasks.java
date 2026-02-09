package AdvancedOperaionsTasks;

import java.util.*;
import java.util.stream.Collectors;

public class AdvancedOperationsTasks {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );
        List<Student> students = Arrays.asList(
                new Student("Ali", "IT", 85),
                new Student("Mona", "CS", 92),
                new Student("Ahmed", "IT", 60),
                new Student("Sara", "CS", 70),
                new Student("Omar", "IS", 45),
                new Student("Laila", "IS", 78)
        );
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
        /********************************************************** Task (1) *****************************************************************/
        // (1) Sort a list of employees by salary then by name.
        List<Employee> sortedEmployees = employees.stream().sorted(
                        Comparator.comparing(Employee::getSalary)   // Sort by salary in ascending order
                                .thenComparing(Employee::getName) // If the salaries are equal ,then sort by name
                ).collect(Collectors.toList());
        sortedEmployees.forEach(employee-> System.out.println(employee.getName() + " - " + employee.getSalary()));

        /********************************************************** Task (2) *****************************************************************/
        // (2) Find the second highest number in a list.
        Optional<Integer>secondHighestNumber=numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        if (secondHighestNumber.isPresent()) // here handle cases where the stream might be empty, preventing NullPointerException if the element is not found.
            System.out.println("the secondHighestNumber is : "+secondHighestNumber.get()); // "secondHighestNumber on the list is 9 "
        else
            System.out.println("the list is empty");

        /********************************************************** Task (3) *****************************************************************/
        // (3) Find duplicate elements in a list of integers.
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = numbers.stream()
       // If add() returns false, it means the number already exists in the Set, so it is a duplicate & The stream filters only those duplicate values and collects them into a Set.
                .filter(n -> !seen.add(n))
                .collect(Collectors.toSet());
        System.out.println("the duplicated elements in the list is : "+ duplicates);

        /********************************************************** Task (4) *****************************************************************/
        // (4) Remove null or empty strings from a list using stream.
        List<String> namesAfterFiltering = names.stream().filter(name -> name != null && !name.isEmpty()).toList();
        System.out.println("the string names without null or empty is "+namesAfterFiltering);

        /********************************************************** Task (5) *****************************************************************/
        // (5) Partition students into pass/fail groups based on grade.
        Map<Boolean, List<Student>> result = students.stream().collect(Collectors.partitioningBy(student -> student.getGrade() >= 60));
        System.out.println("Passed Students:");
        result.get(true).forEach(s -> System.out.println(s.getName()));  // here print names of students that >=60 (passed)
        System.out.println("Failed Students :");
        result.get(false).forEach(s -> System.out.println(s.getName()));  // here print names of students that not >=60 (failed)
    }
}
