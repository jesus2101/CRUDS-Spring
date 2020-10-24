package net.braval.service;

import java.util.List;

import net.braval.model.Animal;

public interface IAnimalService {
	
	
	List<Animal> listarAnimales();
	void registrarAnimal(Animal animal);
	void eliminarAnimal(Integer id);
	Animal actualizarAnimal(Integer id);
	
	

}
