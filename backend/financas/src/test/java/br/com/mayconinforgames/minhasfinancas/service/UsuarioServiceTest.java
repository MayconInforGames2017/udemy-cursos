package br.com.mayconinforgames.minhasfinancas.service;

import static org.mockito.Mockito.mockitoSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mayconinforgames.minhasfinancas.exception.RegraNegocioException;
import br.com.mayconinforgames.minhasfinancas.model.entity.Usuario;
import br.com.mayconinforgames.minhasfinancas.model.repository.UsuarioRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test(expected = Test.None.class)
	public void deveValidarEmail() {
		// cenario
		
		UsuarioRepository usuarioRepository = Mockito.mock(UsuarioRepository.class);
		
		usuarioRepository.deleteAll();
		
		// ação
		usuarioService.validarEmail("email@email.com");
			
	}
	
	@Test(expected = RegraNegocioException.class)
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		// cenario
		Usuario usuario = Usuario.builder().nome("usuario").email("email@email.com").build();
		usuarioRepository.save(usuario);
		
		// ação
		usuarioService.validarEmail("email@email.com");
		
	}
	
}
