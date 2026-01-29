package com.maria.controle_gastos_backend.repositories;

import com.maria.controle_gastos_backend.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    Optional<Categoria> findByCategoria (String categoria);

}
