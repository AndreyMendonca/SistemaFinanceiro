package com.andrey.SistemaFinanceiro.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="tb_cartao_de_credito")
public class CartaoDeCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private BigDecimal limite;

    @Column(name = "vencimento_fatura")
    private Integer vencimentoFatura;

    public CartaoDeCredito(){}

    public CartaoDeCredito(String nome, BigDecimal limite, Integer vencimentoFatura) {
        this.nome = nome;
        this.limite = limite;
        this.vencimentoFatura = vencimentoFatura;
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

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public Integer getVencimentoFatura() {
        return vencimentoFatura;
    }

    public void setVencimentoFatura(Integer vencimentoFatura) {
        this.vencimentoFatura = vencimentoFatura;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CartaoDeCredito that = (CartaoDeCredito) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(limite, that.limite) && Objects.equals(vencimentoFatura, that.vencimentoFatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, limite, vencimentoFatura);
    }
}
