package one_to_one_2;

import one_to_one.Employee;

public class Phone {
    private Integer id;
    private String phoneNumber;
    private Employee employee ;

    public Phone() {
    }

    public Phone(Integer id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
