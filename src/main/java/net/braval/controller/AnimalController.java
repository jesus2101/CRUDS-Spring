package net.braval.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.braval.model.Animal;
import net.braval.service.IAnimalService;

@Controller
@RequestMapping("/animales")
public class AnimalController {
	
	
	@Autowired
	private IAnimalService servAnimal;
	
	
	@PostMapping("/registrar")
	public String crearAnimal(@Valid @ModelAttribute("animal")Animal animal,BindingResult result) {
		if(result.hasErrors()) {
			
			return "animales/formularioAnimal";
		}else {
			servAnimal.registrarAnimal(animal);
			return "redirect:/animales/listar";
		}
		
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarAnimal(@PathVariable("id")int id) {
		
		servAnimal.eliminarAnimal(id);		
		
		return "redirect:/animales/listar";
	}
	
	
	@GetMapping("/editar/{id}")
	public String ediatAnimal(@PathVariable("id")int id,Model model) {
		
		Animal animal=servAnimal.actualizarAnimal(id);
		
		model.addAttribute("animal", animal);
		
		return"animales/formularioAnimal";
	}
	
	
	@GetMapping("/formAnimal")
	public String formularioAnimal(Model model) {
		
		Animal animal=new Animal();
		
		model.addAttribute("animal",animal);
		
		return "animales/formularioAnimal";	
		
	}
	
	
	
	@GetMapping("/listar")
	public String listaAnimales(Model model) {
		
		List<Animal> lista=servAnimal.listarAnimales();
		
		model.addAttribute("animales", lista);
		
		return "animales/listaAnimales";
		
	}

}
