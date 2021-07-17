package br.mayconinforgames.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mayconinforgames.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
