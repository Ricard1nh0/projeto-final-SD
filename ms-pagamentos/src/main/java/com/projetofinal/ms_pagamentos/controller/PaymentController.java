package com.projetofinal.ms_pagamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PaymentController {

    @Autowired private Environment env;

    @PostMapping("/processar")
    public String processarPagamento(@RequestBody String dadosPagamento) {
        String porta = env.getProperty("local.server.port");
        return "Pagamento processado com sucesso pela instância na porta: " + porta;
    }
}   