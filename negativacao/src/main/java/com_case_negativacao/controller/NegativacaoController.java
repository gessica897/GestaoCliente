package com_case_negativacao.controller;

import com_case_negativacao.model.Negativacao;
import com_case_negativacao.repository.NegativacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/negativacoes")
public class NegativacaoController {

    @Autowired
    private NegativacaoRepository negativacaoRepository;

    @PostMapping
    public Negativacao createNegativacao(@RequestBody Negativacao negativacao) {
        return negativacaoRepository.save(negativacao);
    }

    @PutMapping("/{clienteId}/negativar")
    public Negativacao negativarCliente(@PathVariable Long clienteId, @RequestBody String motivo) {
        Negativacao negativacao = negativacaoRepository.findByClienteId(clienteId);
        if (negativacao == null) {
            negativacao = new Negativacao();
            negativacao.setClienteId(clienteId);
        }
        negativacao.setMotivo(motivo);
        negativacao.setNegativado(true);
        return negativacaoRepository.save(negativacao);
    }
}
