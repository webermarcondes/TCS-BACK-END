package com.projetotcs.tcsbackend.services;


import com.projetotcs.tcsbackend.model.Curso;
import com.projetotcs.tcsbackend.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CursoService {

    @Autowired
    CursoRepository repository;

    public List<Curso> findAll(){
        List<Curso> cursos = repository.findAll();

        if(cursos.isEmpty()) {
            throw new ResourceNotFoundException("Não há cursos cadastrados");
        }

        return cursos;
    }

    public Curso findById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não há registro de curso com o ID informado"));

    }

    public Curso create(Curso curso) {
        return repository.save(curso);
    }

    public Curso update(Curso curso, Long id) {

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não há registro de curso com o ID informado para atualizar informações"));

        entity.setNome(curso.getNome());
        entity.setHorasTotais(curso.getHorasTotais());
        entity.setQtdeFases(curso.getQtdeFases());

        repository.save(entity);

        return curso;
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }

}
