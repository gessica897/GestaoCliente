package com_case_negativacao.repository;

import com_case_negativacao.model.Negativacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NegativacaoRepository extends JpaRepository<Negativacao, Long> {

    Negativacao findByClienteId(Long clienteId);
}
