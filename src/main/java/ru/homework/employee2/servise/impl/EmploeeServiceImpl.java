package ru.homework.employee2.servise.impl;

import org.springframework.stereotype.Service;
import ru.homework.employee2.exception.EmployeeAlreadyAddedException;
import ru.homework.employee2.exception.EmployeeNotFoundException;
import ru.homework.employee2.model.Employee;
import ru.homework.employee2.servise.EmployeeService;
import ru.homework.employee2.servise.EmployeeValidationService;

import java.util.*;

@Service

public class EmploeeServiceImpl implements EmployeeService {


    private final Map<String, Employee> employees;
    private final EmployeeValidationService validationService;
    private Employee capitalizeEmployee;

    public EmploeeServiceImpl(List<Employee> employees, EmployeeValidationService validationService) {
        this.validationService = validationService;
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        validationService.validate(firstName, lastName);

        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return capitalizeEmployee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }

}
