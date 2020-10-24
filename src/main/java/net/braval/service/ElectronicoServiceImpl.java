package net.braval.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.braval.model.Electronico;
import net.braval.repository.IElectronicoRepository;

@Service
public class ElectronicoServiceImpl implements IElectronicoService {

	@Autowired
	IElectronicoRepository repoElectronico;
	
	
	@Override
	public List<Electronico> listarElectronico() {
		List<Electronico> lista=repoElectronico.findAll();
		return lista;
	}

	@Override
	public void agregarElectronico(Electronico electronico) {
		
		repoElectronico.save(electronico);

	}

	@Override
	public void eliminarElectronico(Integer id) {
		
		repoElectronico.deleteById(id);

	}

	@Override
	public Electronico electronicoById(Integer id) {
		Optional<Electronico> optional=repoElectronico.findById(id);
		
		if(optional.isPresent()) {
			Electronico electronico=optional.get();
			return electronico;
		}
		
		
		return null;
	}

}
