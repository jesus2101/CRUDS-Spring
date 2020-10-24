package net.braval.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.braval.model.Animal;
import net.braval.repository.IAnimalRepository;


@Service
public class AnimalServiceImpl implements IAnimalService {

	
	@Autowired
	private IAnimalRepository repoAnimal;
	
	
	@Override
	public List<Animal> listarAnimales() {
		
		return repoAnimal.findAll();
	}

	@Override
	public void registrarAnimal(Animal animal) {
		repoAnimal.save(animal);

	}

	@Override
	public void eliminarAnimal(Integer id) {
		
		repoAnimal.deleteById(id);

	}

	@Override
	public Animal actualizarAnimal(Integer id) {
		  Optional<Animal> optional=repoAnimal.findById(id);
		  
		  if(optional.isPresent()) {
			  Animal animal=optional.get();
			  
			  return animal;
		  }
		  
		  return null;
	}

}
