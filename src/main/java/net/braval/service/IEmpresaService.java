package net.braval.service;

import java.util.List;

import net.braval.model.Empresa;

public interface IEmpresaService {
	
	void registrar(Empresa empresa);
	void eliminar(Integer id);
	List<Empresa> listarEmpresas();
	Empresa actualizar(Integer id);

}
