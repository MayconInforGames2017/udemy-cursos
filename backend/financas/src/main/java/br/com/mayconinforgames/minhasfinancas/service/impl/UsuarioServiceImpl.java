package br.com.mayconinforgames.minhasfinancas.service.impl;

import org.springframework.stereotype.Service;

import br.com.mayconinforgames.minhasfinancas.exception.RegraNegocioException;
import br.com.mayconinforgames.minhasfinancas.model.entity.Usuario;
import br.com.mayconinforgames.minhasfinancas.model.repository.UsuarioRepository;
import br.com.mayconinforgames.minhasfinancas.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = usuarioRepository.existsByEmail(email);
		if (existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este e-mail");
		}

	}

}
