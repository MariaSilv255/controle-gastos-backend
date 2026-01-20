package com.maria.controle_gastos_backend.services;

import com.maria.controle_gastos_backend.entities.Despesa;
import com.maria.controle_gastos_backend.exceptions.ResourceNotFoundException;
import com.maria.controle_gastos_backend.repositories.DespesaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
//        return obj.get();

         return obj.orElseThrow(()-> new ResourceNotFoundException(id));

     }

     public Despesa save(Despesa despesa){

         return respository.save(despesa);
     }

     public void delete (long id){
      if(!respository.existsById(id)){
          throw new ResourceNotFoundException(id);
      }else{
          respository.deleteById(id);
      }

     }

     public Despesa update(long id,Despesa despesa){
         try {
             Despesa entidade = respository.getReferenceById(id);
             updateData(entidade,despesa);
             return respository.save(entidade);
         }catch (EntityNotFoundException e){
             throw new ResourceNotFoundException(id);
         }
     }

    private void updateData(Despesa entidade, Despesa despesa) {
        entidade.setData(despesa.getData());
        entidade.setDescricao(despesa.getDescricao());
        entidade.setValor(despesa.getValor());

    }

    public List<Despesa> findByPeriodo(LocalDate dataInicio, LocalDate dataFim){
         if(dataInicio == null || dataFim == null){
            throw new IllegalArgumentException("datas nao pode ser nula");
         }

         if(dataInicio.isAfter(dataFim)){
             throw new IllegalArgumentException("Data Inicio não pode ser maior que a data final");
         }
         return respository.findByDataBetween(dataInicio,dataFim);

    }


}
