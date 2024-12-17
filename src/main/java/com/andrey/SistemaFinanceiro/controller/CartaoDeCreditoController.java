package com.andrey.SistemaFinanceiro.controller;

import com.andrey.SistemaFinanceiro.controller.dto.CartaoDeCreditoDTO;
import com.andrey.SistemaFinanceiro.entity.CartaoDeCredito;
import com.andrey.SistemaFinanceiro.service.CartaoDeCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartoesdecredito")
public class CartaoDeCreditoController {

    @Autowired
    private CartaoDeCreditoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartaoDeCredito save(@RequestBody CartaoDeCreditoDTO dto){
        return service.save(dto);
    }

    @GetMapping("/{id}")
    public CartaoDeCredito findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<CartaoDeCredito> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
