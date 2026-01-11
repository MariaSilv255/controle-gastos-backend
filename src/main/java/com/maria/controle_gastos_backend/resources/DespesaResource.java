package com.maria.controle_gastos_backend.resources;

import com.maria.controle_gastos_backend.entities.Despesa;
import com.maria.controle_gastos_backend.services.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/gastos")
public class DespesaResource {

    @Autowired
    private DespesaService service;

    @GetMapping
    public ResponseEntity <List<Despesa>> findAll(){
        List<Despesa> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
