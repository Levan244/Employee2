package ru.homework.employee2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)

public class employeeStorageIsFullException extends RuntimeException {
    public employeeStorageIsFullException() {
        super("Хранилище сотрудников заполненно!");

    }
}
