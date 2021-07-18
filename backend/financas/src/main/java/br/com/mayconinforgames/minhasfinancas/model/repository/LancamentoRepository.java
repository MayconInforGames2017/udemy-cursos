package br.com.mayconinforgames.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayconinforgames.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
