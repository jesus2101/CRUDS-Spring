package net.braval.service;

import java.util.List;

import net.braval.model.Usuario;

public interface IUsuarioService {
	
	List<Usuario> listaUsuarios();
	void registrarUsuario(Usuario usuario);
	void eliminarUsuario(Integer id);
	Usuario buscarUsuario(Integer id);

}
