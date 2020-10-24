package net.braval.service;

import java.util.List;

import net.braval.model.Serie;

public interface ISerieService {
	
	List<Serie> listarSeries();
	void registrar(Serie serie);
	void eliminar(Integer id);
	Serie actualizarSerie(Integer id);

}
