package com.maria.controle_gastos_backend.resources;

import com.maria.controle_gastos_backend.DTO.DespesaDTO;
import com.maria.controle_gastos_backend.entities.Despesa;
import com.maria.controle_gastos_backend.services.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/despesas")
public class DespesaResource {

    @Autowired
    private DespesaService service;

    @GetMapping
    public ResponseEntity <List<DespesaDTO>> findAll(){
        List<Despesa> list = service.findAll();
        List<DespesaDTO> dto = list.stream().map(DespesaDTO::new).toList();

        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <DespesaDTO> findById(@PathVariable Long id){
        Despesa despesa = service.findById(id);
        return ResponseEntity.ok().body(new DespesaDTO(despesa));
    }

    @PostMapping
    public ResponseEntity<Despesa> save (@RequestBody Despesa despesa){
        Despesa obj = service.save(despesa);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Despesa> update(@PathVariable long id, @RequestBody Despesa despesa){
         despesa =  service.update(id,despesa);
         return ResponseEntity.ok().body(despesa);

    }
    @GetMapping("/periodo")
    public ResponseEntity<List<Despesa>> findByPeriodo(@RequestParam LocalDate dataInicio,@RequestParam LocalDate dataFim){

        List<Despesa> despesa = service.findByPeriodo(dataInicio,dataFim);
        return ResponseEntity.ok().body(despesa);

    }

}
