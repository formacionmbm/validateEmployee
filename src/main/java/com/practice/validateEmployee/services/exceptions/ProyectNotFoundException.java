package com.practice.validateEmployee.services.exceptions;

public class ProyectNotFoundException extends ServiceException{
    public ProyectNotFoundException() {
        super("Proyect not found");
    }
}
