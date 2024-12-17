package com.andrey.SistemaFinanceiro.repository;

import com.andrey.SistemaFinanceiro.entity.CartaoDeCredito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoDeCreditoRepository extends JpaRepository<CartaoDeCredito, Long> {
}
