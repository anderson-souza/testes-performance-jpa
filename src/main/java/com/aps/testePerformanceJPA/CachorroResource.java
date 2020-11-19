package com.aps.testePerformanceJPA;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cachorros")
public class CachorroResource {

    @Autowired
    CachorroService cachorroService;

    @GetMapping
    public List<Cachorro> buscarCachorros() {
        return cachorroService.buscarTodosCachorros();
    }

    @PostMapping
    public void inserirCachorros() {
        cachorroService.inserirCachorros();
    }

    @PostMapping("/batch")
    public void inserirCachorrosBatch() {
        cachorroService.inserirCachorrosBatch();
    }

}
