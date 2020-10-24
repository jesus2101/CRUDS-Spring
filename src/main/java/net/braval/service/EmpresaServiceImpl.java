package net.braval.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.braval.model.Empresa;
import net.braval.repository.IEmpresaRepository;

@Service
public class EmpresaServiceImpl implements IEmpresaService {
	
	@Autowired
	private IEmpresaRepository empresaRepository;

	@Override
	public void registrar(Empresa empresa) {
		// TODO Auto-generated method stub
		
		empresaRepository.save(empresa);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
		empresaRepository.deleteById(id);

	}

	@Override
	public List<Empresa> listarEmpresas() {
		// TODO Auto-generated method stub
		List<Empresa> listaEmpresas=empresaRepository.findAll();
		
		return listaEmpresas;
	}

	@Override
	public Empresa actualizar(Integer id) {
		// TODO Auto-generated method stub
		Optional<Empresa> optional=empresaRepository.findById(id);
		
		if(optional.isPresent()) {
			
			Empresa empresa=optional.get();
			
			return empresa;
		}
		
		
		return null;
	}

}
