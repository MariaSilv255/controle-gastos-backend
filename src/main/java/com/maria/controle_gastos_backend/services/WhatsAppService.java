package com.maria.controle_gastos_backend.services;

import com.maria.controle_gastos_backend.entities.Categoria;
import com.maria.controle_gastos_backend.entities.Despesa;
import com.maria.controle_gastos_backend.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class WhatsAppService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private DespesaService despesaService;

    public void processarMensagem(String mensagem, String telefone){

        String[] msg = mensagem.split(" ");

        if(msg.length < 2){
            throw new IllegalArgumentException("formato invalido. User: 55 alimentação");
        }

        Usuario usuario = usuarioService.findByTelefone(telefone);
        BigDecimal valor = new BigDecimal(msg[0]);
        Categoria categoria = categoriaService.findByCategoria(msg[1]);

        Despesa despesa = new Despesa();
        despesa.setCategoria(categoria);
        despesa.setData(LocalDate.now());
        despesa.setValor(valor);
        despesa.setUsuario(usuario);
        despesa.setDescricao("via whatsapp");

        despesaService.save(despesa);

    }

}
