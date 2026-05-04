package many_to_many;

import java.util.List;

public class Patient {
    private Integer id;
    private String name;
    private int age;
    private Doctor doctar;
    private List<Doctor> doctars;

    public Patient() {
    }

    public Patient(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Doctor getDoctar() {
        return doctar;
    }

    public void setDoctar(Doctor doctar) {
        this.doctar = doctar;
    }

    public List<Doctor> getDoctars() {
        return doctars;
    }

    public void setDoctars(List<Doctor> doctars) {
        this.doctars = doctars;
    }
}
