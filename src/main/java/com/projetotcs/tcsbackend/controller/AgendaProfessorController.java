package com.projetotcs.tcsbackend.controller;

import com.projetotcs.tcsbackend.model.AgendaProfessorModel;
import com.projetotcs.tcsbackend.services.AgendaProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/agenda-professor")
public class AgendaProfessorController {

    @Autowired
    AgendaProfessorService service;

    @GetMapping(value="/get-agendas-professores")
    public List<AgendaProfessorModel> getAgendaProfessores(){
        return service.findAll();
    }

    @GetMapping(value="/get-agenda-professor/{id}")
    public AgendaProfessorModel getAgendaProfessorById(@PathVariable(value="id") Long id) {
        return service.findById(id);
    }

    @PostMapping(value="/create-agenda-professor")
    public ResponseEntity<AgendaProfessorModel> createAgendaProfessor(@RequestBody AgendaProfessorModel agendaProfessor) {

        return new ResponseEntity<>(service.create(agendaProfessor), HttpStatus.CREATED);
    }


    @PutMapping(value="/update-agenda-professor/{id}")
    public AgendaProfessorModel updateAgendaProfessor(@RequestBody AgendaProfessorModel agendaProfessor, @PathVariable(value="id") Long id) {
        return service.update(agendaProfessor, id);
    }

    @DeleteMapping(value="/delete-agenda-professor/{id}")
    public ResponseEntity<AgendaProfessorModel> deleteAgendaProfessor(@PathVariable(value="id") Long id) {

        service.delete(id);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
