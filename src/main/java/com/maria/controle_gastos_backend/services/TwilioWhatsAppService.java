package com.maria.controle_gastos_backend.services;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioWhatsAppService {

        @Value("${twilio.whatsappNumber}")
        private String fromNumber;

        public void enviarMensagem(String to, String texto) {


            if (!to.startsWith("whatsapp:")) {
                to = "whatsapp:" + to;
            }

            Message.creator(
                    new PhoneNumber(to),
                    new PhoneNumber(fromNumber),
                    texto
            ).create();

            System.out.println("✅ Mensagem enviada para: " + to);
        }
}
