package ru.homework.employee2.servise;

import org.springframework.stereotype.Service;
import ru.homework.employee2.exception.EmployeeAlreadyAddedException;
import ru.homework.employee2.exception.EmployeeNotFoundException;
import ru.homework.employee2.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service

public class EmploeeServiceImpl implements EmployeeService {

    private static final int EMPLOYEE_MAX_COUNT = 5;
    private final List<Employee> employees;

    public EmploeeServiceImpl(List<Employee> employees) {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size() >= EMPLOYEE_MAX_COUNT) {
            throw new EmployeeNotFoundException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees;
    }

}
