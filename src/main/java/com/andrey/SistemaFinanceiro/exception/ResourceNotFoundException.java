package com.andrey.SistemaFinanceiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ResourceNotFoundException extends ErroSistemException{

    private String detail;

    public ResourceNotFoundException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pb.setTitle("ENTIDADE NÃO LOCALIZADA");
        pb.setDetail(detail);
        return pb;
    }
}
