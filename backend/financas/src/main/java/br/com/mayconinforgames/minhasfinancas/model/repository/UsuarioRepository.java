package br.com.mayconinforgames.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayconinforgames.minhasfinancas.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	boolean existsByEmail(String email);
	
}
