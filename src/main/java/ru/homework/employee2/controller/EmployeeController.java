package ru.homework.employee2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.homework.employee2.model.Employee;
import ru.homework.employee2.servise.EmployeeService;

import java.util.Collection;

import static ru.homework.employee2.servise.impl.EmployeeServiceImpl.DEPARTMENT_ID;
import static ru.homework.employee2.servise.impl.EmployeeServiceImpl.SALARY;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.add(firstName, lastName, SALARY, DEPARTMENT_ID);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.add(firstName, lastName, SALARY, DEPARTMENT_ID);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.add(firstName, lastName, SALARY, DEPARTMENT_ID);
    }

    @GetMapping
    public Collection<Employee> findALl() {
        return employeeService.findAll();
    }

}
