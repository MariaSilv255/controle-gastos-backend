package com.maria.controle_gastos_backend.resources;

import com.maria.controle_gastos_backend.entities.Categoria;
import com.maria.controle_gastos_backend.entities.Despesa;
import com.maria.controle_gastos_backend.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> list =service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria categoria = service.findById(id);
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){

        Categoria obj = service.save(categoria);
        return ResponseEntity.ok().body(obj);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Categoria> update (@PathVariable Long id, @RequestBody Categoria categoria){
        categoria = service.update(id,categoria);
        return ResponseEntity.ok().body(categoria);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
