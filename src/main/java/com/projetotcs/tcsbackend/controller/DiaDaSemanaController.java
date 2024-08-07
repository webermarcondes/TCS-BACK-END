package com.projetotcs.tcsbackend.controller;

import com.projetotcs.tcsbackend.model.DiaDaSemanaModel;
import com.projetotcs.tcsbackend.services.DiaDaSemanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api/dia-da-semana")
public class DiaDaSemanaController {

    @Autowired
    DiaDaSemanaService service;

    @GetMapping("/get-dias-da-semana")
    public List<DiaDaSemanaModel> getDiasDaSemana() {
        return service.findAll();
    }

    @GetMapping("/get-dia-da-semana/{id}")
    public DiaDaSemanaModel getDiaDaSemanaById(@PathVariable(name="id") Long id) {
        return service.findById(id);
    }

    @GetMapping("/get-dia-da-semana-by-descricao/{descricao}")
    public DiaDaSemanaModel getDiaDaSemanaByDescricao(@PathVariable(name="descricao") String descricao) {
        return service.findByDescricao(descricao);
    }
}
