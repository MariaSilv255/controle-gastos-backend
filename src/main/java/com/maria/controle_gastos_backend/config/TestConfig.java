package com.maria.controle_gastos_backend.config;

import com.maria.controle_gastos_backend.entities.Categoria;
import com.maria.controle_gastos_backend.entities.Despesa;
import com.maria.controle_gastos_backend.entities.Usuario;
import com.maria.controle_gastos_backend.repositories.CategoriaRepository;
import com.maria.controle_gastos_backend.repositories.DespesaRepository;
import com.maria.controle_gastos_backend.repositories.UsuarioRepository;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {


        Categoria categoriaa = new Categoria(null,"Alimentação");
        Categoria categoriab = new Categoria(null,"Moradia");

        categoriaRepository.saveAll(Arrays.asList(categoriaa,categoriab));

        Usuario user2 = new Usuario(null,"maira aparecida","84987518025","123456","maria@gmail");
        Usuario user1 = new Usuario(null,"maira","84987518025","123456","maria@gmail");

        usuarioRepository.saveAll(Arrays.asList(user1,user2));

        Despesa despesa1 = new Despesa(null,"compra de comida",new BigDecimal(12.0), LocalDate.now(),categoriaa,user2);
        Despesa despesa2 = new Despesa(null,"compra remedio",new BigDecimal(122.0), LocalDate.now(),categoriab,user1);


        despesaRepository.saveAll(Arrays.asList(despesa1,despesa2));



    }
}
