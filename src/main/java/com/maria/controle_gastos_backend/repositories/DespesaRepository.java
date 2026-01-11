package com.maria.controle_gastos_backend.repositories;

import com.maria.controle_gastos_backend.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa,Long > {

}
