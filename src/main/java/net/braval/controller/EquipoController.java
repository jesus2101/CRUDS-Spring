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

import net.braval.model.Equipo;
import net.braval.service.IEquipoService;

@Controller
@RequestMapping("/equipo")
public class EquipoController {
	
	@Autowired
	IEquipoService serviceEquipo;
	
	@GetMapping("/listar")
	public String listarEquipos(Model model) {
		
		List<Equipo> lista=serviceEquipo.listarEquipo();
		
		model.addAttribute("listaEquipos", lista);
		
		return "listaEquipo";
		
	}
	
	@GetMapping("/formulario")
	public String formulario(Model model) {
		
		Equipo equipo =new Equipo();
		
		model.addAttribute("equipo", equipo);
		
		return "formularioEquipo";
		
	}
	
	@PostMapping("/nuevoEquipo")
	public String nuevoEquipo(@Valid @ModelAttribute("equipo") Equipo equipo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "formularioEquipo";
		}else {
			
			serviceEquipo.agregarEquipo(equipo);
			return "redirect:/equipo/listar";
		}
		
	}
	
	
	@GetMapping("/eliminarEquipo/{id}")
	public String eliminarEquipo(@PathVariable("id")int id){
		
		serviceEquipo.eliminarEquipo(id);
		
		return "redirect:/equipo/listar";
		
	}

	@GetMapping("/actualizarEquipo/{id}")
	public String actualizarEquipo(@PathVariable("id")int id, Model model) {
		
		Equipo equipo=serviceEquipo.actualizarEquipo(id);
		model.addAttribute("equipo", equipo);
		
		return "formularioEquipo"; 
		
	}

}
