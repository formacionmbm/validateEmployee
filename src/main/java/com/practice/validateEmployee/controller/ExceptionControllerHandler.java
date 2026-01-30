package com.practice.validateEmployee.controller;

import com.practice.searchEmployees.common.CodeError;
import com.practice.searchEmployees.common.StateEmployee;
import com.practice.searchEmployees.common.TypeEmployee;
import com.practice.searchEmployees.services.exceptions.EmployeeNotFoundException;
import com.practice.searchEmployees.services.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = Controller.class)
@Slf4j
public class ExceptionControllerHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFoundException(
            EmployeeNotFoundException ex,
            Model model
    ) {
        log.info("[handleEmployeeNotFoundException]");

        model.addAttribute("error",CodeError.EMPLOYEE_NOT_FOUND.getMessage());
        log.debug("[error {}]",CodeError.EMPLOYEE_NOT_FOUND.getMessage());

        model.addAttribute("states", StateEmployee.values());
        model.addAttribute("types", TypeEmployee.values());
        return "search/t_search_employees";
    }

    @ExceptionHandler(ServiceException.class)
    public String handleServiceException(
            ServiceException ex,
            Model model
    ) {
        log.info("[handleServiceException]");
        model.addAttribute("error",CodeError.SERVICE.getMessage());
        log.debug("[error {}]",CodeError.SERVICE.getMessage());
        return "error/error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericException(
            Exception ex,
            Model model
    ) {
        log.info("[handleGenericException]");
        model.addAttribute("error","ERROR_500");
        log.debug("[error ERROR_500]");
        return "error/500";
    }
}

