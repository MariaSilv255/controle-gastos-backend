package com.maria.controle_gastos_backend.services;

import com.maria.controle_gastos_backend.entities.Categoria;
import com.maria.controle_gastos_backend.entities.Usuario;
import com.maria.controle_gastos_backend.exceptions.ResourceNotFoundException;
import com.maria.controle_gastos_backend.repositories.CategoriaRepository;
import com.maria.controle_gastos_backend.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.orElseThrow(() ->new ResourceNotFoundException("Resource not found id" + id));
    }

    public Usuario findByTelefone(String telefone){
        return repository.findBytelefone(telefone).orElseThrow(() -> new ResourceNotFoundException("Resource not found telefone" + telefone));
    }


    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found id" + id);
        } else {
            repository.deleteById(id);
        }
    }

    public Usuario update(Long id, Usuario usuario) {

        try {
            Usuario entidade = repository.getReferenceById(id);
            updateData(entidade, usuario);
            return repository.save(entidade);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Resource not found id" + id);
        }


    }

    public void updateData(Usuario entidade, Usuario usuario) {
        entidade.setNome(usuario.getNome());
        entidade.setEmail(usuario.getEmail());
        entidade.setTelefone(usuario.getTelefone());
        entidade.setSenha(usuario.getSenha());

    }
}

