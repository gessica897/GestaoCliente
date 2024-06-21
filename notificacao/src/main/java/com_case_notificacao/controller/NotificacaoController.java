package com_case_notificacao.controller;

import com_case_notificacao.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping("/email")
    public void sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
        notificacaoService.sendEmail(to, subject, body);
    }

    @PostMapping("/sms")
    public void sendSms(@RequestParam String to, @RequestParam String message) {
        notificacaoService.sendSms(to, message);
    }
}
