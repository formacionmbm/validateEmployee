package com.practice.validateEmployee.services.exceptions;

public class ActivityNotFoundException extends ServiceException{
    public ActivityNotFoundException() {
        super("Activity not found");
    }
}
