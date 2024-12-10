package com.andrey.SistemaFinanceiro.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Boolean despesa;
    @Column(nullable = false)
    private Boolean receita;

    public Categoria(){}

    public Categoria(String nome, Boolean despesa, Boolean receita) {
        this.nome = nome;
        this.despesa = despesa;
        this.receita = receita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getDespesa() {
        return despesa;
    }

    public void setDespesa(Boolean despesa) {
        this.despesa = despesa;
    }

    public Boolean getReceita() {
        return receita;
    }

    public void setReceita(Boolean receita) {
        this.receita = receita;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id) && Objects.equals(nome, categoria.nome) && Objects.equals(despesa, categoria.despesa) && Objects.equals(receita, categoria.receita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, despesa, receita);
    }
}
