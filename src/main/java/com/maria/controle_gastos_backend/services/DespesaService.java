package com.maria.controle_gastos_backend.services;

import com.maria.controle_gastos_backend.entities.Despesa;
import com.maria.controle_gastos_backend.exceptions.ResourceNotFoundException;
import com.maria.controle_gastos_backend.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

     @Autowired
    private DespesaRepository respository;

     public List<Despesa> findAll(){
         return respository.findAll();
     }

     public Despesa findById(Long id){
        Optional<Despesa> obj = respository.findById(id);
        return obj.get();

         //return respository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Despesa não encontrada"));

     }

     public Despesa save(Despesa despesa){
         return respository.save(despesa);
     }

     public void delete (long id){
          respository.deleteById(id);
     }

     public Despesa update(long id,Despesa despesa){
         Despesa entidade = respository.getReferenceById(id);
         updateData(id,despesa);
         return respository.save(entidade);
     }

    private void updateData(long id, Despesa despesa) {
         despesa.setData(despesa.getData());
         despesa.setDescricao(despesa.getDescricao());
         despesa.setValor(despesa.getValor());
    }

}
