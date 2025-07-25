package com.example.jpalearn.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, HttpServletRequest request){
        logger.error("Going to log error in controller advice");
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimestamp(LocalDateTime.now());
        errorDetail.setMessage(ex.getMessage());
        errorDetail.setPath( request.getRequestURI());
        errorDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorDetail,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> UserNotFoundException(Exception ex, HttpServletRequest request){
        logger.error("Going to log  UserNotFoundException error in controller advice");
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimestamp(LocalDateTime.now());
        errorDetail.setMessage(ex.getMessage());
        errorDetail.setPath( request.getRequestURI());
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorDetail,HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();

        ex.getFieldErrors().forEach(error ->{
            errors.put(error.getField(),error.getDefaultMessage());
        });
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimestamp(LocalDateTime.now());
        errorDetail.setMessage(errors.toString());
        //errorDetail.setPath( request.getRequestURI());
        errorDetail.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDetail,HttpStatus.BAD_REQUEST);
    }
}
