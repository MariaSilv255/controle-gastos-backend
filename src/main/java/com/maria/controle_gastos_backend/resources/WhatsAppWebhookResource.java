package com.maria.controle_gastos_backend.resources;

import com.maria.controle_gastos_backend.DTO.WhatsAppMessageDTO;
import com.maria.controle_gastos_backend.services.WhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/webhook")
public class WhatsAppWebhookResource {

    @Autowired
    private WhatsAppService service;

    @PostMapping("/whatsapp")
    public ResponseEntity<String> getMessage (@RequestBody WhatsAppMessageDTO dto){
        service.processarMensagem(dto.getMensagem() ,dto.getTelefone());
        return  ResponseEntity.ok("Despesa registrada com sucesso");
    }
}
