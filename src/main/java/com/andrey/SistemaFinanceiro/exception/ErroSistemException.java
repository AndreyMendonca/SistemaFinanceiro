package com.andrey.SistemaFinanceiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ErroSistemException extends RuntimeException{
    public ProblemDetail toProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle("ERRO INTERNO DE SISTEMA");

        return pb;
    }
}
