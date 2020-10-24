package net.braval.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.braval.model.Usuario;
import net.braval.repository.IUsuarioRepository;


@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepository repoUsuario;
	
	
	@Override
	public List<Usuario> listaUsuarios() {
		// TODO Auto-generated method stub
		return repoUsuario.findAll();
	}

	@Override
	public void registrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

		repoUsuario.save(usuario);
		
		
	}

	@Override
	public void eliminarUsuario(Integer id) {
		// TODO Auto-generated method stub

		repoUsuario.deleteById(id);
	}

	@Override
	public Usuario buscarUsuario(Integer id) {
		// TODO Auto-generated method stub
		Optional<Usuario> optional=repoUsuario.findById(id);
		
		if(optional.isPresent()) {
			Usuario usuario=optional.get();
			
			return usuario;
		}
		
		return null;
	}

}
