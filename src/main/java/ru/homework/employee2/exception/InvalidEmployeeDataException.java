package ru.homework.employee2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmployeeDataException extends RuntimeException{
    public InvalidEmployeeDataException() {
        super("Invalid Employee Data Exception");
    }
}
