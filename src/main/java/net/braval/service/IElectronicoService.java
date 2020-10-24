package net.braval.service;

import java.util.List;

import net.braval.model.Electronico;

public interface IElectronicoService {
	
	List<Electronico> listarElectronico();
	void agregarElectronico(Electronico electronico);
	void eliminarElectronico(Integer id);
	Electronico electronicoById(Integer id);
	
	
	

}
