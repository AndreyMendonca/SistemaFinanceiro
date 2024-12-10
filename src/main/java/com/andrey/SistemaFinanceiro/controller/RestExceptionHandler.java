package com.andrey.SistemaFinanceiro.controller;

import com.andrey.SistemaFinanceiro.exception.ErroSistemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ErroSistemException.class)
    public ProblemDetail handleErroSistemException(ErroSistemException e){
        return e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        var fieldErros = e.getFieldErrors()
                .stream()
                .map(f -> new InvalidParam(f.getField(),f.getDefaultMessage()))
                .toList();
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Os parametros enviados estão incorretos");
        pb.setProperty("Parametros invalidos",fieldErros);
        return pb;
    }

    private record InvalidParam(String name, String reason){}
}
