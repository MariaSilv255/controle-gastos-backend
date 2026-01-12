package com.maria.controle_gastos_backend.config;

import com.maria.controle_gastos_backend.entities.Despesa;
import com.maria.controle_gastos_backend.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private DespesaRepository despesaRepository;


    @Override
    public void run(String... args) throws Exception {
        Despesa despesa1 = new Despesa(null,"compra de comida",new BigDecimal(12.0), LocalDate.now());
        Despesa despesa2 = new Despesa(null,"compra remedio",new BigDecimal(122.0), LocalDate.now());
        despesaRepository.saveAll(Arrays.asList(despesa1,despesa2));
    }
}
