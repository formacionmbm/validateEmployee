package com.practice.validateEmployee.services.exceptions;

public class EmployeeNotFoundException extends ServiceException{
    public EmployeeNotFoundException() {
        super("Employee not found");
    }
}
