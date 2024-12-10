package com.andrey.SistemaFinanceiro.entity;

import com.andrey.SistemaFinanceiro.entity.enums.StatusEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_contas_pagar")
public class ContasPagar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private BigDecimal valor;
    @Column(name = "data_de_vencimento")
    private LocalDate dataDeVencimento;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    public ContasPagar(){}

    public ContasPagar(String descricao, BigDecimal valor, LocalDate dataDeVencimento, StatusEnum status) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataDeVencimento = dataDeVencimento;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContasPagar that = (ContasPagar) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(valor, that.valor) && Objects.equals(dataDeVencimento, that.dataDeVencimento) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, valor, dataDeVencimento, status);
    }
}
