package net.braval.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.braval.model.Personaje;
import net.braval.repository.IPersonajeRepository;

@Service
public class PersonajeServiceImpl implements IPersonajeService {
    
	@Autowired
	private IPersonajeRepository personajeRepository;
	
	@Override
	public void registrar(Personaje personaje) {
		// TODO Auto-generated method stub
		
		
		personajeRepository.save(personaje);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
      personajeRepository.deleteById(id);
	}

	@Override
	public Personaje actualizar(Integer id) {
		// TODO Auto-generated method stub
      Optional<Personaje> optional=personajeRepository.findById(id);
      
      if(optional.isPresent()){
    	 Personaje personaje=optional.get();
    	 
    	 return personaje;    	  
      }
      
      return null;
	}

	@Override
	public List<Personaje> listar() {
		// TODO Auto-generated method stub
		List<Personaje> lista=personajeRepository.findAll();
		
		return lista;
		
		
		
		
	}

}
