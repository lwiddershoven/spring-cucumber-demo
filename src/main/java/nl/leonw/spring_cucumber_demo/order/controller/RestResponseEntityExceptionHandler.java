package nl.leonw.spring_cucumber_demo.order.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {ResourceNotFoundException.class})
    protected ResponseEntity<Object> notFound(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}