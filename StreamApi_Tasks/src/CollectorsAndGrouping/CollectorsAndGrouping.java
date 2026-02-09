package CollectorsAndGrouping;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsAndGrouping {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
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
        /********************************************************** Task (1) *****************************************************************/
        // (1) Group a list of students by their department.
        Map<String,List<Student>> groupsOfStudentByDept= students.stream().collect(Collectors.groupingBy(Student::getDepartment));
        // This code iterates over each department and prints all student names belonging to that department by doing Loop through students list for this department & print each studentName
        groupsOfStudentByDept.forEach((dept, list) -> {
            System.out.println("Dept "+dept +" has students with names : ");
            list.forEach(student -> System.out.println(student.getName()));
        });

        /********************************************************** Task (2) *****************************************************************/
        // (2) Partition a list of numbers into even and odd using partitioningBy.
        Map<Boolean, List<Integer>> result = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even numbers: " + result.get(true));  // [10, 2, 10, 8, 0, 4]
        System.out.println("Odd numbers: " + result.get(false));  // [5, 3, 7, 5, 9, -3]

        /********************************************************** Task (3) *****************************************************************/
        // (3) Create a comma-separated string from a list of strings.
        String separatedNames=names.stream().collect(Collectors.joining(","));
        System.out.println(separatedNames);  // Ali,Mona,Ahmed,Sara,Amr,Laila,Kareem,Nada,Nour,Samy,,null

        /********************************************************** Task (4) *****************************************************************/
        // (4) Group employees by age and count how many per age.
        Map<Integer,List<Employee>>groupsOfStudentByAge=employees.stream().collect(Collectors.groupingBy(Employee::getAge));
        // This code iterates over each groupAge and prints the count of each groupAge
        groupsOfStudentByAge.forEach((age,employes)-> System.out.println("the number of employes with age "+age+ " is "+employes.stream().count()));

        /********************************************************** Task (5) *****************************************************************/
        // (5) Find the average salary per department in a list of employees.
        Map<String, Double> avgSalaryByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        // This code iterates over each groupDepartment and get the average salary of all salaries in each dept
        avgSalaryByDept.forEach((dept,avgSalary)-> System.out.println(dept+ " the average salary is "+avgSalary));







    }
}
