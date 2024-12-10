package com.andrey.SistemaFinanceiro.controller.dto;

import com.andrey.SistemaFinanceiro.entity.ContasReceber;
import com.andrey.SistemaFinanceiro.entity.enums.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CriarContasReceberDTO(String descricao,
                                    BigDecimal valor,
                                    LocalDate dataDeVencimento,
                                    String status) {
    public ContasReceber toContasReceber(){
        return new ContasReceber(descricao,valor,dataDeVencimento, StatusEnum.valueOf(status));
    }
}

