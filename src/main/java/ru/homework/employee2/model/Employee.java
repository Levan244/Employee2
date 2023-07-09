package ru.homework.employee2.model;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int departmentId;

    public Employee(int salary, int departmentId) {
        this.salary = salary;
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public Employee(String firstName, String lastName) {
        Random random = new Random();

        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = random.nextInt(10000) + 1000;
        this.departmentId = random.nextInt(5) + 1;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
