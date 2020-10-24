package net.braval.service;

import java.util.List;

import net.braval.model.Banda;

public interface IBandaService {
    List<Banda> listarBandas();
	void registrar(Banda banda);
	void eliminar(Integer id);
	Banda bandaPorId(Integer id);
	
}
