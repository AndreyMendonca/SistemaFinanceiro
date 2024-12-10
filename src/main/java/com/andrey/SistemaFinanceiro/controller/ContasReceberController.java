package com.andrey.SistemaFinanceiro.controller;

import com.andrey.SistemaFinanceiro.controller.dto.CriarContasReceberDTO;
import com.andrey.SistemaFinanceiro.entity.ContasReceber;
import com.andrey.SistemaFinanceiro.service.ContasReceberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contasReceber")
public class ContasReceberController {

    @Autowired
    private ContasReceberService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContasReceber save(@RequestBody @Valid CriarContasReceberDTO dto){
        return service.save(dto);
    }

    @GetMapping("/{id}")
    public ContasReceber findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<ContasReceber> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PatchMapping("/{id}")
    public ContasReceber pagamentoConta(@PathVariable Long id){
        return service.pagamentoConta(id);
    }
}
