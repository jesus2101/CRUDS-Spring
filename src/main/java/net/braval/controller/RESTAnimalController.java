package net.braval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.braval.model.Animal;
import net.braval.service.IAnimalService;

@CrossOrigin(origins="")
@RestController
@RequestMapping("/restAnimales")
public class RESTAnimalController {
	
	@Autowired
	private IAnimalService servAnimal;
	
	@GetMapping
	public List<Animal> listarAnimales(){
		return servAnimal.listarAnimales();
	}
	
	
	
}
