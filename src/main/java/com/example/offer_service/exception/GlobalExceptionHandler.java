package com.example.offer_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errores = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            Map<String, String> datosError = new HashMap<>();
            datosError.put("campo", error.getField());
            datosError.put("error", error.getDefaultMessage());
            errores.add(datosError);
        });
        return ResponseEntity.badRequest().body(Map.of("errores", errores));
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleInvalidData(HttpMessageNotReadableException ex) {
        String msj = ex.getMessage();
        if(msj != null && msj.contains("Categoria")){
            Map<String, String> error = new HashMap<>();
            error.put("campo", "categoria");
            error.put("error", "Categoria invalida");
            List<Map<String, String>> errores = List.of(error);
            return ResponseEntity.badRequest().body(Map.of("errores", errores));
        }
        return ResponseEntity
                .badRequest()
                .body("El formato del campo es inválido. Verifique los datos enviados.");
    }
}
