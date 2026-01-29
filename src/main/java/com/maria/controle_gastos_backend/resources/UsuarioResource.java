package com.maria.controle_gastos_backend.resources;

import com.maria.controle_gastos_backend.entities.Usuario;
import com.maria.controle_gastos_backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> list =service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario categoria = service.findById(id);
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){

        Usuario obj = service.save(usuario);
        return ResponseEntity.ok().body(obj);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update (@PathVariable Long id, @RequestBody Usuario usuario){
        usuario = service.update(id,usuario);
        return ResponseEntity.ok().body(usuario);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
