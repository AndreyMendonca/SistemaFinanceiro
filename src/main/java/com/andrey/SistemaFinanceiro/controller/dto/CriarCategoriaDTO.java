package com.andrey.SistemaFinanceiro.controller.dto;

import com.andrey.SistemaFinanceiro.entity.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarCategoriaDTO(@NotBlank(message = "Preencha o nome") String nome,
                                @NotNull(message = "Preencha se o campo é uma despesa") Boolean despesa,
                                @NotNull(message = "Preencha se o campo é uma receita") Boolean receita) {
    public Categoria toCategoria(){
        return new Categoria(nome,despesa,receita);
    }
}
