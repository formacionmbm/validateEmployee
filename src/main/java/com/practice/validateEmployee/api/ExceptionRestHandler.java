package com.practice.validateEmployee.api;


import com.practice.validateEmployee.common.CodeError;
import com.practice.validateEmployee.services.exceptions.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Locale;

@RestControllerAdvice(annotations = RestController.class)
@Slf4j
public class ExceptionRestHandler {
    private final MessageSource messageSource;

    public ExceptionRestHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }



    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(
            ServiceException ex,
            HttpServletRequest request,
            Locale locale
    ) {
        log.info("[handleServiceException]");
        String msg = messageSource.getMessage(CodeError.SERVICE.getMessage(), null, locale);
        ErrorResponse error = ErrorResponse.builder()
                .status(CodeError.SERVICE.getCode())
                .error("Business Error")
                .message(msg)
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
        log.debug("[error {}]",error);
        return ResponseEntity
                .status(CodeError.SERVICE.getCode())
                .body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request
    ) {
        log.info("[handleGenericException]");
         ErrorResponse error = ErrorResponse.builder()
                 .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                 .error("Internal Server Error")
                 .message("Unexpected error occurred")
                 .path(request.getRequestURI())
                 .timestamp(LocalDateTime.now())
                 .build();
        log.debug("[error {}]",error);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }
}

