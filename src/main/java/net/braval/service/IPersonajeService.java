package net.braval.service;

import java.util.List;

import net.braval.model.Personaje;

public interface IPersonajeService {
	
	void registrar(Personaje personaje);
	void eliminar(Integer id);
	Personaje actualizar(Integer id);
	List<Personaje> listar();

}
