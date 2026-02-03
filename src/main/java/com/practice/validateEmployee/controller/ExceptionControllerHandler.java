package com.practice.validateEmployee.controller;


import com.practice.validateEmployee.common.CodeError;
import com.practice.validateEmployee.services.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = Controller.class)
@Slf4j
public class ExceptionControllerHandler {



    @ExceptionHandler(ServiceException.class)
    public String handleServiceException(
            ServiceException ex,
            Model model
    ) {
        log.info("[handleServiceException]");
        model.addAttribute("error", CodeError.SERVICE.getMessage());
        log.debug("[error {}]",CodeError.SERVICE.getMessage());
        return "error/error";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidException(
            MethodArgumentNotValidException maex,
            Model model, BindingResult result
    ) {
        log.info("[handleValidException]");
        model.addAttribute("errors",result.getFieldErrors());

        return "/admin/t_employee_new";
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

