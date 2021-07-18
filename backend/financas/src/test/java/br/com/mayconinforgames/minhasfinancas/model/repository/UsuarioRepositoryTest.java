package br.com.mayconinforgames.minhasfinancas.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.mayconinforgames.minhasfinancas.model.entity.Usuario;

@DataJpaTest 
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	public void deveVerificarExistenciaDeUmEmail() {
		// cenario
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario.@email.com").build();
		usuarioRepository.save(usuario);
		
		// ação
		boolean result = usuarioRepository.existsByEmail("usuario.@email.com");
		
		// verificação
		Assertions.assertThat(result).isTrue();
		
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComEmail() {
		// cenario
		usuarioRepository.deleteAll();
		
		// ação
		boolean result = usuarioRepository.existsByEmail("usuario.@email.com");
	
		// verificacao
		Assertions.assertThat(result).isFalse();
	}
	
}
