package net.braval.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.braval.model.Equipo;
import net.braval.repository.IEquipoRepository;

@Service
public class EquipoServiceImpl implements IEquipoService {

	
	@Autowired
	IEquipoRepository repoEquipo;
	
	@Override
	public void agregarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		
		repoEquipo.save(equipo);

	}

	@Override
	public List<Equipo> listarEquipo() {
		// TODO Auto-generated method stub
		
		
		List<Equipo> list=repoEquipo.findAll();
		return list;
	}

	@Override
	public void eliminarEquipo(Integer id) {
		// TODO Auto-generated method stub
		
		repoEquipo.deleteById(id);

	}

	@Override
	public Equipo actualizarEquipo(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<Equipo> optional=repoEquipo.findById(id);
		
		if(optional.isPresent()) {
			Equipo equipo=optional.get();
			return equipo;
		}
		

		return null;
	}

}
