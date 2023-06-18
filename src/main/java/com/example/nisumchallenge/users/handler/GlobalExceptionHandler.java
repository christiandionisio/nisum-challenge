package com.example.nisumchallenge.users.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(DataIntegrityViolationException ex) {
    Map<String, String> errors = new HashMap<>();
    errors.put("email", "El correo ya registrado.");
    log.info(errors.toString());
    return ResponseEntity.badRequest().body(errors);
  }

}
