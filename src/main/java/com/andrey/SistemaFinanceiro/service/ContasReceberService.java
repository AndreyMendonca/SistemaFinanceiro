package com.andrey.SistemaFinanceiro.service;

import com.andrey.SistemaFinanceiro.controller.dto.CriarContasReceberDTO;
import com.andrey.SistemaFinanceiro.entity.Categoria;
import com.andrey.SistemaFinanceiro.entity.ContasReceber;
import com.andrey.SistemaFinanceiro.exception.ResourceNotFoundException;
import com.andrey.SistemaFinanceiro.exception.TipoCategoriaInvalidoException;
import com.andrey.SistemaFinanceiro.repository.CategoriaRepository;
import com.andrey.SistemaFinanceiro.repository.ContasReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasReceberService {
    @Autowired
    private ContasReceberRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public ContasReceber save(CriarContasReceberDTO dto){
        Categoria categoria = categoriaRepository.findById(dto.categoria())
                .orElseThrow(()-> new ResourceNotFoundException("Categoria não existe"));

        if(!categoria.getReceita()){
            throw new TipoCategoriaInvalidoException("A categoria não é uma receita");
        }

        ContasReceber contasReceber = dto.toContasReceber();
        contasReceber.setCategoria(categoria);
        return repository.save(contasReceber);
    }

    public ContasReceber findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ContasReceber não existe"));
    }

    public List<ContasReceber> findAll(){
        return repository.findAll();
    }

    public void delete(Long id){
        repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ContasReceber não existe"));
        repository.deleteById(id);
    }

    public ContasReceber pagamentoConta(Long id){
        ContasReceber contaReceber = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ContasReceber não existe"));

        contaReceber.pagamentoConta();

        return repository.save(contaReceber);
    }
}
