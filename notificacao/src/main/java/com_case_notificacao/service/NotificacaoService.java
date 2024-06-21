package com_case_notificacao.service;

import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    public void sendEmail(String to, String subject, String body) {
        // Lógica de envio de email
    }

    public void sendSms(String to, String message) {
        // Lógica de envio de SMS
    }
}
