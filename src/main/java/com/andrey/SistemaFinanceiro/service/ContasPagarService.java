package com.andrey.SistemaFinanceiro.service;

import com.andrey.SistemaFinanceiro.controller.dto.CriarContasPagarDTO;
import com.andrey.SistemaFinanceiro.entity.ContasPagar;
import com.andrey.SistemaFinanceiro.exception.ResourceNotFoundException;
import com.andrey.SistemaFinanceiro.repository.ContasPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasPagarService {
    @Autowired
    private ContasPagarRepository repository;

    public ContasPagar save(CriarContasPagarDTO dto){
        return repository.save(dto.toContasPagar());
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
