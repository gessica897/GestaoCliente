package com_case_negociacao.controller;

import com_case_negociacao.model.Renegociacao;
import com_case_negociacao.repository.RenegociacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/renegociacoes")
public class RenegociacaoController {

    @Autowired
    private RenegociacaoRepository renegociacaoRepository;

    @GetMapping("/cliente/{clienteId}")
    public List<Renegociacao> getRenegociacoesByClienteId(@PathVariable Long clienteId) {
        return renegociacaoRepository.findByClienteId(clienteId);
    }

    @PostMapping
    public Renegociacao createRenegociacao(@RequestBody Renegociacao renegociacao) {
        return renegociacaoRepository.save(renegociacao);
    }

    @PutMapping("/{id}/aprovar")
    public Renegociacao aprovarRenegociacao(@PathVariable Long id) {
        Renegociacao renegociacao = renegociacaoRepository.findById(id).orElse(null);
        if (renegociacao != null) {
            renegociacao.setStatus("Aprovado");
            // Lógica adicional para atualizar saldo do cliente
            return renegociacaoRepository.save(renegociacao);
        }
        return null;
    }
}
