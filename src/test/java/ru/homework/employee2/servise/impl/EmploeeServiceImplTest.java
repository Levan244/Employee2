package ru.homework.employee2.servise.impl;
import org.junit.jupiter.api.Test;
import ru.homework.employee2.model.Employee;
import ru.homework.employee2.servise.EmployeeService;
import ru.homework.employee2.servise.impl.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static ru.homework.employee2.servise.impl.EmployeeTestConstants.*;

class EmployeeServiceImplTest {
    private final EmployeeValidationServiceImpl employeeValidationService = new EmployeeValidationServiceImpl();
    private final EmployeeServiceImpl emploeeServiceImple = new EmployeeServiceImpl(employeeValidationService);

    @Test
    public void shouldAddEmployee() {
        Employee employee = new Employee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);

        assertFalse(emploeeServiceImple.findAll().contains(employee));

        Employee addedEmployee = emploeeServiceImple.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertEquals(employee, addedEmployee);
        assertTrue(emploeeServiceImple.findAll().contains(employee));
        assertEquals(1,emploeeServiceImple.findAll().size());
    }

}