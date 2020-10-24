package net.braval.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.braval.model.Genero;
import net.braval.repository.IGeneroRepository;

@Service
public class GeneroServiceImpl implements IGeneroService {

	@Autowired
	IGeneroRepository generoRepository;
	
	
	@Override
	public void registrar(Genero genero) {
		// TODO Auto-generated method stub
		
		
		generoRepository.save(genero);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
		generoRepository.deleteById(id);

	}

	@Override
	public List<Genero> listar() {
		// TODO Auto-generated method stub
		
		List<Genero> lista=generoRepository.findAll();
		
		return lista;
	}

	@Override
	public Genero generoPorId(Integer id) {
		// TODO Auto-generated method stub
	Optional<Genero> optional=generoRepository.findById(id);
		
		if(optional.isPresent()) {
			Genero gen=optional.get();
			
			return gen;
		}
		
		return null;
	}
	
	
	

}
