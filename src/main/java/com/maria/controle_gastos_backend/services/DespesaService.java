package com.maria.controle_gastos_backend.services;

import com.maria.controle_gastos_backend.entities.Despesa;
import com.maria.controle_gastos_backend.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DespesaService {

     @Autowired
    private DespesaRepository respository;

     public List<Despesa> findAll(){
         return respository.findAll();
     }



}
