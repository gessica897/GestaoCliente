package com_case_negociacao.repository;

import com_case_negociacao.model.Renegociacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RenegociacaoRepository extends JpaRepository<Renegociacao, Long> {

    List<Renegociacao> findByClienteId(Long clienteId);
}
