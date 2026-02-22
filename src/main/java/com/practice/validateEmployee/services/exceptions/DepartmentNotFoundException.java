package com.practice.validateEmployee.services.exceptions;

public class DepartmentNotFoundException extends ServiceException{
    public DepartmentNotFoundException() {
        super("Department not found");
    }
}
