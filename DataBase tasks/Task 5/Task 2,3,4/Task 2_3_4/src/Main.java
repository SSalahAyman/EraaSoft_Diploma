import many_to_many.Doctor;
import many_to_many.Patient;
import one_to_many.Language;
import one_to_many.Teacher;
import one_to_one.Employee;
import one_to_one.Phone;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //**************************************Task 4 (one to one Relationship) ************************************************************//
        // Create one Employee and one Phone
        Employee employee1= new Employee(1,"salah",23);
        Phone phone1 = new Phone(1,"01145606447");

        // Link both sides of the relationship (Employee ↔ Phone)
        employee1.setPhone(phone1);
        phone1.setEmployee(employee1);

        // From Phone → get its Employee → then print Employee name
        // This proves that one phone is linked to exactly one employee
        System.out.println(phone1.getEmployee().getName());

        // From Employee → get its Phone → then print phone number
        // This proves that one employee has exactly one phone
        System.out.println(employee1.getPhone().getPhoneNumber());



        //**************************************Task 3 (one to many Relationship) ************************************************************//
        // Create multiple Teachers
        Teacher teacher1 = new Teacher (1,"ahmed",5000);
        Teacher teacher2 = new Teacher (1,"hamdy",5000);
        Teacher teacher3 = new Teacher (1,"shady",5000);
        // Create one Language
        Language language1 = new Language(1,"English");

        // Assign many teachers to one language (Language → Teachers)
        language1.setTeachers(List.of(teacher1,teacher2,teacher3));

        // Assign the same language to each teacher (Teacher → Language)
        teacher1.setLanguage(language1);
        teacher2.setLanguage(language1);
        teacher3.setLanguage(language1);

        // From Language → get all related Teachers (One → Many)
        System.out.println("Language 1 teachers :");
        language1.getTeachers().stream().forEach(teacher-> System.out.println("...." + teacher.getName() ));

        // From each Teacher → get its Language (Many → One)
        // This confirms that multiple teachers share the same language
        System.out.println(teacher1.getLanguage().getName());
        System.out.println(teacher2.getLanguage().getName());
        System.out.println(teacher3.getLanguage().getName());



        //**************************************Task 2 (many to many Relationship) ************************************************************//
        // Create Doctors
        Doctor doctor1 = new Doctor(1,"salah",5000);
        Doctor doctor2 = new Doctor(2,"Ahmed",7000);
        Doctor doctor3 = new Doctor(3,"Eman",6000);
        // Create Patients
        Patient patient1 = new Patient(1,"Ayman",22);
        Patient patient2 = new Patient(2,"Alaa",24);
        Patient patient3 = new Patient(3,"Maha",23);

        // Assign multiple patients to one doctor
        doctor1.setPatients(List.of(patient1,patient2,patient3));
        // Assign multiple doctors to one patient
        patient1.setDoctars(List.of(doctor1,doctor2,doctor3));

        // From Doctor → get all its Patients (Many side)
        System.out.println("Doctor 1 patients :");
        doctor1.getPatients().stream().forEach(patient-> System.out.println("...." + patient.getName()));

        // From Patient → get all its Doctors (Many side)
        System.out.println("Patient 1 Doctors :");
        patient1.getDoctars().stream().forEach(doctor-> System.out.println("...." + doctor.getName()));




    }
}

