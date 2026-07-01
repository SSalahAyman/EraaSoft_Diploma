package org.example.entity;


import javax.persistence.*;

@Entity(name="TEACHER")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TEACHER_ID")
    private Long id ;

    @Column(name="TEACHER_NAME", length = 50,nullable = false)
    private String name;

    @Column(name="TEACHER_AGE",nullable = false, columnDefinition = "NUMBER(2) CHECK (TEACHER_AGE BETWEEN 15 AND 20)")
    private Integer age;

    @Column(name="TEACHER_ADDRESS" ,unique = true,nullable = false)
    private String address;

    public Teacher() {
    }

    public Teacher(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 15 || age > 20) {
            throw new IllegalArgumentException("Age must be between 15 and 20");
        }
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
