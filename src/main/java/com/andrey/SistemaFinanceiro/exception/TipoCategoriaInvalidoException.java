package com.andrey.SistemaFinanceiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TipoCategoriaInvalidoException extends ErroSistemException{

    private String detail;

    public TipoCategoriaInvalidoException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("CATEGORIA NÃO PODE SER ADICIONADA.");
        pb.setDetail(detail);
        return pb;
    }
}
