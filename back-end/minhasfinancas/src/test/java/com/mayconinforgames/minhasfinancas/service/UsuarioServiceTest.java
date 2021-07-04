package com.mayconinforgames.minhasfinancas.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.RepositoryType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mayconinforgames.minhasfinancas.model.entity.Usuario;
import com.mayconinforgames.minhasfinancas.model.repository.UsuarioRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

	@Autowired
	UsuarioService service;

	@Autowired
	UsuarioRepository repository;

	@Test
	public void deveValidarEmail() {
		// cenario
		repository.deleteAll();

		// acao
		service.validarEmail("usuario@email.com");
	}

	// Os testes deste código não irão passar 
	// precisa ser @Test(expected = RegraNegocioException.class)
	@Test
	public void deveLancaErroAoValidarEmailCadastradoQExistirEmailCadastrado() {
		// cenario
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
		repository.save(usuario);
		
		// acao
		service.validarEmail("usuario@email.com");
	}

}
