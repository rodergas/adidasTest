package com.adidas.test.publicservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleContraintViolationException(MethodArgumentNotValidException  exception) {
        List<String> errors = exception.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error", errors);
        return ResponseEntity.badRequest().body(body);
    }
}
