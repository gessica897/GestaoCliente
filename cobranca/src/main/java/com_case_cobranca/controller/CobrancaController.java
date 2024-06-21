package com_case_cobranca.controller;

import com_case_cobranca.model.Fatura;
import com_case_cobranca.repository.FaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class CobrancaController {

    @Autowired
    private FaturaRepository faturaRepository;

    @GetMapping("/cliente/{clienteId}")
    public List<Fatura> getFaturasByClienteId(@PathVariable Long clienteId) {
        return faturaRepository.findByClienteIdAndPagaFatura(clienteId);
    }

    @PostMapping
    public Fatura createFatura(@RequestBody Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    @PutMapping("/{id}/pagar")
    public Fatura pagarFatura(@PathVariable Long id) {
        Fatura fatura = faturaRepository.findById(id).orElse(null);
        if (fatura != null) {
            fatura.setPaga(true);
            return faturaRepository.save(fatura);
        }
        return null;
    }
}
