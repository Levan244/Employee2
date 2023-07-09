package ru.homework.employee2.servise;

import ru.homework.employee2.model.Employee;

import java.util.Collection;
import java.util.Collections;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();
}
