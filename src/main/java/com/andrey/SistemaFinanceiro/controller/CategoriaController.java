package com.andrey.SistemaFinanceiro.controller;

import com.andrey.SistemaFinanceiro.controller.dto.CriarCategoriaDTO;
import com.andrey.SistemaFinanceiro.entity.Categoria;
import com.andrey.SistemaFinanceiro.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody CriarCategoriaDTO dto){
        return service.save(dto);
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Categoria> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
