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
import org.springframework.web.bind.annotation.RequestParam;

import net.braval.model.Genero;
import net.braval.service.IGeneroService;

@Controller
@RequestMapping(value="/genero")
public class GeneroController {
	
	@Autowired
	private IGeneroService generoService;
	
	
	@GetMapping("/editar/{id}")
	public String editarGenero(@PathVariable("id")int id, Model model) {
		
		Genero gen=generoService.generoPorId(id);
		
		model.addAttribute("genero", gen);
		return "formularioGenero";	
		
	}	
	
	
	@PostMapping("/insertar")
	public String insertarGenero(@Valid @ModelAttribute("genero")Genero genero,BindingResult binding) {
		
		if(binding.hasErrors()) {
			return "formularioGenero";
		}else {
			generoService.registrar(genero);
			return "redirect:/genero/listar";
		}
		
		
	}
	
	
	@GetMapping("/formGenero")
	public String crearFormularioGenero(Model modelo) {
		
		Genero genero=new Genero();
		
		modelo.addAttribute("genero", genero);
		
		return "formularioGenero";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminarGenero(@PathVariable("id")int id) {
		
		generoService.eliminar(id);
		return "redirect:/genero/listar";
	}
	
	
	@GetMapping("/listar")
	public String listarGenero(Model model) {
		
		List<Genero> lista=generoService.listar();
		
		model.addAttribute("lista", lista);
		return "listaGenero";
		
	}

}
