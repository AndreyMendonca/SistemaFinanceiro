package com.andrey.SistemaFinanceiro.service;

import com.andrey.SistemaFinanceiro.controller.dto.CriarCategoriaDTO;
import com.andrey.SistemaFinanceiro.entity.Categoria;
import com.andrey.SistemaFinanceiro.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public Categoria save(CriarCategoriaDTO dto){
        return repository.save(dto.toCategoria());
    }

    public Categoria findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException());
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
