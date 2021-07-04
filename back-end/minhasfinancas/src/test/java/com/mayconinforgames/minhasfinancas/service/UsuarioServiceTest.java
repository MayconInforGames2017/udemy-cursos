package com.mayconinforgames.minhasfinancas.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.mayconinforgames.minhasfinancas.exception.RegraNegocioException;
import com.mayconinforgames.minhasfinancas.model.entity.Usuario;
import com.mayconinforgames.minhasfinancas.model.repository.UsuarioRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

	@Autowired
	UsuarioService service;

	@Autowired
	UsuarioRepository repository;

	@Test(expected = Test.None.class)
	public void deveValidarEmail() {
		// cenario
		repository.deleteAll();

		// acao
		service.validarEmail("usuario@email.com");
	}

	@Test(expected = RegraNegocioException.class)
	public void deveLancaErroAoValidarEmailCadastradoQExistirEmailCadastrado() {
		// cenario
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
		repository.save(usuario);

		// acao
		service.validarEmail("usuario@email.com");
	}

}
