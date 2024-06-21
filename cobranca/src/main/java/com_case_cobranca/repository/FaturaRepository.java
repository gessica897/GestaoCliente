package com_case_cobranca.repository;

import com_case_cobranca.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaturaRepository extends JpaRepository<Fatura, Long> {

    List<Fatura> findByClienteIdAndPagaFatura(Long clienteId);
}
