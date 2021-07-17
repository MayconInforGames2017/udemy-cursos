package br.mayconinforgames.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mayconinforgames.minhasfinancas.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
