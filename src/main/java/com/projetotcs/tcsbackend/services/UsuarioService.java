package com.projetotcs.tcsbackend.services;


import com.projetotcs.tcsbackend.model.Usuario;
import com.projetotcs.tcsbackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro de usuário foi encontrado com o ID informado"));

    }

    public Usuario create(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario update(Usuario usuario, Long id) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro de usuário foi encontrado com o ID informado"));

        entity.setEmail(usuario.getEmail());
        entity.setNome(usuario.getNome());
        entity.setSenha(usuario.getSenha());
        entity.setStatus(usuario.getStatus());
        //entity.setNivelPermissao(usuario.getNivelPermissao());

        repository.save(entity);

        return usuario;
    }


    /*public void delete(Long id) {

        repository.deleteById(id);
    }*/
}