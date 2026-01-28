package com.maria.controle_gastos_backend.services;

import com.maria.controle_gastos_backend.entities.Categoria;
import com.maria.controle_gastos_backend.exceptions.ResourceNotFoundException;
import com.maria.controle_gastos_backend.repositories.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria findById(Long id){
        Optional<Categoria> categoria = repository.findById(id);
        //return categoria.get();
        return categoria.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Categoria save(Categoria categoria){
        return repository.save(categoria);
    }

    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }else{
            repository.deleteById(id);
        }
    }

    public Categoria update(Long id,Categoria categoria){

        try{
        Categoria entidade = repository.getReferenceById(id);
        updateData(entidade,categoria);
        return repository.save(entidade);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }


    }

    public void updateData(Categoria entidade, Categoria categoria){
       entidade.setCategoria(categoria.getCategoria());
    }
}
