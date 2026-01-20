package com.maria.controle_gastos_backend.repositories;

import com.maria.controle_gastos_backend.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa,Long > {

    List<Despesa> findByDataBetween(LocalDate dataInicial, LocalDate dataFinal);


}
