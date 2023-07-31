package ru.homework.employee2.servise.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.homework.employee2.exception.EmployeeNotFoundException;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;
import static ru.homework.employee2.servise.impl.EmployeeTestConstants.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    private void shouldReturnTotalSalaryByDepartmentId() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(DEPARTAMENT_TOTAL_SALARY, departmentService.getDepartmentSalarySum(DEPARTMENT_ID));

    }

    @Test
    private void shouldReturnEmployeeWithMaxByDepartmentId() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    private void shouldReturnEmployeeWithMinByDepartmentId() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    private void shouldTrowEmployeeNotFoundExeptionWhenFindEmployeeWithMaxSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));


    }

    @Test
    private void shouldTrowEmployeeNotFoundExeptionWhenFindEmployeeWithMinSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmployeesByDepartmentId() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(EMPLOYEES, departmentService.findEmployeesByDepartment(DEPARTMENT_ID));
        assertEquals(singletonList(OTHER_DEPARTMENT_EMPLOYEE), departmentService.findEmployeesByDepartment(DEPARTMENT_ID2));
    }

    @Test
    private void shouldReturnAllEmployee() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(EMPLOYEE_BY_DEPARTMENT_MAP, departmentService.findEmployeesByDepartment());

    }@Test
    private void shouldReturnEmptyMapWhenFindAllEmployee() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertEquals(emptyMap(),departmentService.findEmployeesByDepartment());

    }
}
