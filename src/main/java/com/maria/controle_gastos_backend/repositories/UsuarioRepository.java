package com.maria.controle_gastos_backend.repositories;

import com.maria.controle_gastos_backend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
