package net.braval.service;

import java.util.List;

import net.braval.model.Equipo;

public interface IEquipoService {
	
	void agregarEquipo (Equipo equipo);
	List<Equipo> listarEquipo();
	void eliminarEquipo (Integer id);
	Equipo actualizarEquipo(Integer id);

}
