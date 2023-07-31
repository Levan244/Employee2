package ru.homework.employee2.servise.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;
import ru.homework.employee2.exception.EmployeeAlreadyAddedException;
import ru.homework.employee2.exception.EmployeeNotFoundException;
import ru.homework.employee2.model.Employee;


import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.homework.employee2.servise.impl.EmployeeTestConstants.*;

@ExtendWith(MockitoExtension.class)


public class EmployeeServiceImplTest {
    private final EmployeeValidationServiceImpl employeeValidationService = new EmployeeValidationServiceImpl();
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeValidationService);

    @Test
    public void shouldAddEmployee() {
        Employee employee = new Employee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertFalse(employeeService.findAll().contains(employee));

        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertEquals(employee, addedEmployee);
        assertTrue(employeeService.findAll().contains(employee));
        assertEquals(1, employeeService.findAll().size());
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedException() {
        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertTrue(employeeService.findAll().contains(addedEmployee));
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID));

    }

    @Test
    public void shouldFindEmployee() {
        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertEquals(addedEmployee, employeeService.find(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFind() {
        assertEquals(0, employeeService.findAll().size());
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.find(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldRemoveEmployee() {
        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertTrue(employeeService.findAll().contains(addedEmployee));
        assertEquals(1, employeeService.findAll().size());

        Employee removedEmployee = employeeService.remove(FIRST_NAME, LAST_NAME);
        assertEquals(addedEmployee,removedEmployee);
        assertFalse(employeeService.findAll().contains(addedEmployee));
        assertEquals(0, employeeService.findAll().size());

    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenRemove() {
        assertEquals(0, employeeService.findAll().size());
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.remove(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldReturnAllEmployees() {
        Employee employee1 = employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        Employee employee2 = employeeService.add(FIRST_NAME2, LAST_NAME2, SALARY, DEPARTMENT_ID2);

        Collection<Employee> addedEmployee = employeeService.findAll();

        assertIterableEquals(List.of(employee1,employee2),addedEmployee);
    }
}