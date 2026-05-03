import one_to_many.Language;
import one_to_many.Teacher;
import one_to_one.Employee;
import one_to_one.Phone;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //**************************************Task 4 (one to one relation represent) ************************************************************//
        Employee employee1= new Employee(1,"salah",23);
        Phone phone1 = new Phone(1,"01145606447");

        employee1.setPhone(phone1);
        phone1.setEmployee(employee1);

        // here from phone1 we get the employee that is related to it , then get it is name , and here appear one employee only to one phone number
        System.out.println(phone1.getEmployee().getName());  // "salah"
        // here from phone1 we get the employee that is related to it , then get it is name , and here appear one employee only to one phone number
        System.out.println(employee1.getPhone().getPhoneNumber());

        //**************************************Task 3 (one to many relation represent) ************************************************************//
        Teacher teacher1 = new Teacher (1,"ahmed",5000);
        Teacher teacher2 = new Teacher (1,"hamdy",5000);
        Teacher teacher3 = new Teacher (1,"shady",5000);
        Language language1 = new Language(1,"English");

        language1.setTeachers(List.of(teacher1,teacher2,teacher3));

        teacher1.setLanguage(language1);
        teacher2.setLanguage(language1);
        teacher3.setLanguage(language1);

        language1.getTeachers().stream().forEach(teacher-> System.out.println("...." + teacher.getName() ));

        System.out.println(teacher1.getLanguage().getName());
        System.out.println(teacher2.getLanguage().getName());
        System.out.println(teacher3.getLanguage().getName());

        //**************************************Task 2 (many to many relation represent) ************************************************************//

    }
}

