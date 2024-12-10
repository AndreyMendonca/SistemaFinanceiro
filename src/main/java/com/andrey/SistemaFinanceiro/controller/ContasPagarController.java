package com.andrey.SistemaFinanceiro.controller;

import com.andrey.SistemaFinanceiro.controller.dto.CriarContasPagarDTO;
import com.andrey.SistemaFinanceiro.entity.ContasPagar;
import com.andrey.SistemaFinanceiro.service.ContasPagarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contasPagar")
public class ContasPagarController {

    @Autowired
    private ContasPagarService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContasPagar save(@RequestBody @Valid CriarContasPagarDTO dto){
        return service.save(dto);
    }

    @GetMapping("/{id}")
    public ContasPagar findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<ContasPagar> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
