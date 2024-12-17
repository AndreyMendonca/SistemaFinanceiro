package com.andrey.SistemaFinanceiro.service;

import com.andrey.SistemaFinanceiro.controller.dto.CartaoDeCreditoDTO;
import com.andrey.SistemaFinanceiro.entity.CartaoDeCredito;
import com.andrey.SistemaFinanceiro.entity.Categoria;
import com.andrey.SistemaFinanceiro.exception.ResourceNotFoundException;
import com.andrey.SistemaFinanceiro.repository.CartaoDeCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoDeCreditoService {
    @Autowired
    private CartaoDeCreditoRepository repository;

    public CartaoDeCredito save(CartaoDeCreditoDTO dto){
        return repository.save(dto.toCartaoDeCredito());
    }

    public CartaoDeCredito findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cartão de credito não existe"));
    }

    public List<CartaoDeCredito> findAll(){
        return repository.findAll();
    }

    public void delete(Long id){
        repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cartão de credito não existe"));
        repository.deleteById(id);
    }

}
