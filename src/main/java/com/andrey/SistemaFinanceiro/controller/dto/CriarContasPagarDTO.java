package com.andrey.SistemaFinanceiro.controller.dto;

import com.andrey.SistemaFinanceiro.entity.ContasPagar;
import com.andrey.SistemaFinanceiro.entity.enums.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CriarContasPagarDTO(String descricao,
                                  BigDecimal valor,
                                  LocalDate dataDeVencimento,
                                  String status) {
    public ContasPagar toContasPagar(){
        return new ContasPagar(descricao,valor,dataDeVencimento, StatusEnum.valueOf(status));
    }
}

