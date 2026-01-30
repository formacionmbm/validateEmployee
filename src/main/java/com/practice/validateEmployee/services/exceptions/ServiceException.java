package com.practice.validateEmployee.services.exceptions;


import com.practice.validateEmployee.common.AppException;

public class ServiceException extends AppException {

    public ServiceException(){
        super("General Error Service Layer");
    }
    public ServiceException(String mensagge){
        super(mensagge);
    }
}
