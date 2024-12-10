package com.andrey.SistemaFinanceiro.controller.dto;

import com.andrey.SistemaFinanceiro.entity.Categoria;

public record CriarCategoriaDTO(String nome,
                                Boolean despesa,
                                Boolean receita) {
    public Categoria toCategoria(){
        return new Categoria(nome,despesa,receita);
    }
}
