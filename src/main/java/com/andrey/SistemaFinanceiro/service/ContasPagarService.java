package com.andrey.SistemaFinanceiro.service;

import com.andrey.SistemaFinanceiro.controller.dto.CriarContasPagarDTO;
import com.andrey.SistemaFinanceiro.entity.Categoria;
import com.andrey.SistemaFinanceiro.entity.ContasPagar;
import com.andrey.SistemaFinanceiro.exception.ResourceNotFoundException;
import com.andrey.SistemaFinanceiro.exception.TipoCategoriaInvalidoException;
import com.andrey.SistemaFinanceiro.repository.CategoriaRepository;
import com.andrey.SistemaFinanceiro.repository.ContasPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasPagarService {
    @Autowired
    private ContasPagarRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public ContasPagar save(CriarContasPagarDTO dto){
        Categoria categoria = categoriaRepository.findById(dto.categoria())
                .orElseThrow(()->new ResourceNotFoundException("Categoria não existe"));
        if(!categoria.getDespesa()){
            throw new TipoCategoriaInvalidoException("Habilite a categoria para ser uma despesa");
        }

        ContasPagar contasPagar = dto.toContasPagar();
        contasPagar.setCategoria(categoria);

        return repository.save(contasPagar);
    }

    public ContasPagar findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ContasPagar não existe"));
    }

    public List<ContasPagar> findAll(){
        return repository.findAll();
    }

    public void delete(Long id){
        repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ContasPagar não existe"));
        repository.deleteById(id);
    }

    public ContasPagar pagamentoConta(Long id){
        ContasPagar contaPagar = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ContaPagar não existe"));

        contaPagar.pagamentoConta();

        return repository.save(contaPagar);
    }
}
