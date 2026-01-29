package com.maria.controle_gastos_backend.repositories;

import com.maria.controle_gastos_backend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findBytelefone (String telefone);

}
