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

import net.braval.model.Empresa;
import net.braval.model.Personaje;
import net.braval.service.IEmpresaService;
import net.braval.service.IPersonajeService;

@Controller
@RequestMapping("/personaje")
public class PersonajeController {
	
	
	@Autowired
	private IPersonajeService personajeService;
	
	@Autowired
	private IEmpresaService empresaService;
	
	
	@GetMapping("/listarPersonajes")
	public String listarPersonajes(Model model) {
		
		List<Personaje> listaPersonaje=personajeService.listar();
		model.addAttribute("personajes", listaPersonaje);
		
		return "listaPersonajes";
	}
	
	@GetMapping("/formPersonaje")
	public String formularioPersonaje(Model model) {
		
		Personaje personaje=new Personaje();
		List<Empresa> empresas=empresaService.listarEmpresas();
		
		model.addAttribute("personaje", personaje);
		model.addAttribute("empresas", empresas);
		
		
		return "formularioPersonaje";
	}
	
	@PostMapping("/crear")
	public String crearPersonaje(@Valid @ModelAttribute("personaje")Personaje personaje,BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "formularioPersonaje";
		}else {
			
			personajeService.registrar(personaje);
			
			return "redirect:/personaje/listarPersonajes";
		}
		
	}
	
	@GetMapping("/editar/{id}")
	public String editarPersonaje(@PathVariable("id")int id,Model model) {
		
		List<Empresa> listaEmpresas=empresaService.listarEmpresas();
		Personaje personaje=personajeService.actualizar(id);
		
		model.addAttribute("empresas", listaEmpresas);
		model.addAttribute("personaje", personaje);
		
		return "formularioPersonaje";
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarPersonaje(@PathVariable("id")int id) {
		
		personajeService.eliminar(id);
		
		
		return "redirect:/personaje/listarPersonajes";
		
	}
	
	

}
