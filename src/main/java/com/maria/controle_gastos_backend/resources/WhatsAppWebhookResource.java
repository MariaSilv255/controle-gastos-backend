package com.maria.controle_gastos_backend.resources;

import com.maria.controle_gastos_backend.DTO.WhatsAppMessageDTO;
import com.maria.controle_gastos_backend.services.TwilioWhatsAppService;
import com.maria.controle_gastos_backend.services.WhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/webhook")
public class WhatsAppWebhookResource {

    @Autowired
    private WhatsAppService whatsAppService;

    @Autowired
    private TwilioWhatsAppService twilioService;

    @GetMapping("/ping")
    public String ping() {
        System.out.println("🔥 Webhook ping chegou!");
        return "OK";
    }

    @PostMapping("/whatsapp")
    public ResponseEntity<Void> receberMensagem(
            @RequestParam("From") String from,
            @RequestParam("Body") String body
    ) {


        whatsAppService.processarMensagem(body, from);


        twilioService.enviarMensagem(
                from,
                "✅ Despesa registrada com sucesso: " + body
        );

        return ResponseEntity.ok().build();
    }

}
