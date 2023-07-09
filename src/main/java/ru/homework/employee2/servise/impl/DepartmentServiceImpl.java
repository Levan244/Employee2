package ru.homework.employee2.servise.impl;

import org.springframework.stereotype.Service;
import ru.homework.employee2.exception.EmployeeNotFoundException;
import ru.homework.employee2.model.Employee;
import ru.homework.employee2.servise.DepartmentService;
import ru.homework.employee2.servise.EmployeeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee findEmployeeWithMaxSalary(int departmendtId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmendtId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int departmendtId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmendtId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(int departmendtId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmendtId)
                .sorted(Comparator.comparing(Employee::getFullName).thenComparing(Employee::getFirstName))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartment() {
        return employeeService.findAll().stream()
                .sorted(Comparator.comparing(Employee::getFullName).thenComparing(Employee::getFirstName))
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
