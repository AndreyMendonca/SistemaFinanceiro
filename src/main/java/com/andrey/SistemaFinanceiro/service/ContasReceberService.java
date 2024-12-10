package com.andrey.SistemaFinanceiro.service;

import com.andrey.SistemaFinanceiro.controller.dto.CriarContasReceberDTO;
import com.andrey.SistemaFinanceiro.entity.ContasReceber;
import com.andrey.SistemaFinanceiro.exception.ResourceNotFoundException;
import com.andrey.SistemaFinanceiro.repository.ContasReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasReceberService {
    @Autowired
    private ContasReceberRepository repository;

    public ContasReceber save(CriarContasReceberDTO dto){
        return repository.save(dto.toContasReceber());
    }

    public ContasReceber findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ContasReceber não existe"));
    }

    public List<ContasReceber> findAll(){
        return repository.findAll();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
