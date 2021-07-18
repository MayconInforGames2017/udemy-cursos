package br.com.mayconinforgames.minhasfinancas.model.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
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

	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void deveVerificarExistenciaDeUmEmail() {
		// cenario
		Usuario usuario = criarUsuario();
		//usuarioRepository.save(usuario);
		entityManager.persist(usuario);
		
		// ação
		boolean result = usuarioRepository.existsByEmail("usuario.@email.com");
		
		// verificação
		Assertions.assertThat(result).isFalse();
		
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComEmail() {
		// cenario
		//usuarioRepository.deleteAll();
		
		// ação
		boolean result = usuarioRepository.existsByEmail("usuario.@email.com");
	
		// verificacao
		Assertions.assertThat(result).isFalse();
	}
	
	@Test
	public void devePersistirUmUsuarioNaBaseDeDados() {
		// cenario
		Usuario usuario = criarUsuario();
		
		// ação
		Usuario usuarioCadastrado = usuarioRepository.save(usuario);
	
		// verificacao
		Assertions.assertThat(usuarioCadastrado.getId()).isNotNull();
	
	}
	
	@Test
	public void deveBuscarUmUsuarioPorEmail() {
		// cenario
		Usuario usuario = criarUsuario();
		entityManager.persist(usuario);
		
		// acao
		Optional<Usuario> result = usuarioRepository.findByEmail("usuario@email.com");
		
		// verificacao
		Assertions.assertThat(result.isPresent()).isTrue();
		
	}
	
	@Test
	public void deveRetornarVazioAoBuscarUmUsuarioPorEmailQuandoNaoExisteNaBase() {
		
		// acao
		Optional<Usuario> result = usuarioRepository.findByEmail("usuario@email.com");
		
		// verificacao
		Assertions.assertThat(result.isPresent()).isFalse();
		
	}
	
	public static Usuario criarUsuario() {
		return Usuario
				.builder()
				.nome("usuario")
				.email("usuario@email.com")
				.senha("senha")
				.build();
	}
	
}
