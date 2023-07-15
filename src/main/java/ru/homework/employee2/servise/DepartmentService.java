package ru.homework.employee2.servise;

import ru.homework.employee2.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Integer getDepartmentSalarySum(int departmentId);
    Employee findEmployeeWithMaxSalary(int departmendtId);

    Employee findEmployeeWithMinSalary(int departmendtId);

    Collection<Employee> findEmployeesByDepartment(int departmendtId);

    Map<Integer, List<Employee>> findEmployeesByDepartment();

}

