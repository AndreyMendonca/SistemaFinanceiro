package com.andrey.SistemaFinanceiro.repository;

import com.andrey.SistemaFinanceiro.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
