package com.andrey.SistemaFinanceiro.controller.dto;

import com.andrey.SistemaFinanceiro.entity.CartaoDeCredito;

import java.math.BigDecimal;

public record CartaoDeCreditoDTO(String nome, BigDecimal limite, Integer vencimentoFatura) {
    public CartaoDeCredito toCartaoDeCredito(){
        return new CartaoDeCredito(nome, limite, vencimentoFatura);
    }
}
