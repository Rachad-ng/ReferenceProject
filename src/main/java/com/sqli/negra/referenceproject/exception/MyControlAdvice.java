package com.sqli.negra.referenceproject.exception;

import com.sqli.negra.referenceproject.dto.MessageDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyControlAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = DataStoreException.class)
    protected ResponseEntity<Object> dataStoreExceptionHandler(
            DataStoreException ex, WebRequest request) {

        MessageDto messageDto = new MessageDto(ex.getMessage(), "500");
        return handleExceptionInternal(ex, messageDto,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value
            = DataNotFoundException.class)
    protected ResponseEntity<Object> dataNotFoundExceptionHandler(
            DataNotFoundException ex, WebRequest request) {

        MessageDto messageDto = new MessageDto(ex.getMessage(), "400");
        return handleExceptionInternal(ex, messageDto,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
