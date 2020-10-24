package net.braval.service;

import java.util.List;

import net.braval.model.Genero;

public interface IGeneroService {
	
	void registrar(Genero genero);
	void eliminar (Integer id);
	List<Genero> listar();
	Genero generoPorId(Integer id);

}
