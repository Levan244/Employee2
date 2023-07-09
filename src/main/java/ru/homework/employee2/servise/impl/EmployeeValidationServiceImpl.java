package ru.homework.employee2.servise.impl;

import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.homework.employee2.servise.EmployeeValidationService;
import ru.homework.employee2.exception.InvalidEmployeeDataException;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {

    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }

    private void validateName(String name) {
        if (!isAlpha(name)) {
            throw new InvalidEmployeeDataException();

        }
    }

}
