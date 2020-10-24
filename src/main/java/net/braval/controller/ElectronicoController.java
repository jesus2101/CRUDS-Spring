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

import net.braval.model.Electronico;
import net.braval.service.IElectronicoService;

@Controller
@RequestMapping("/electronico")
public class ElectronicoController {

	
	@Autowired
	IElectronicoService serviceElec;
	
	@GetMapping("/listar")
	public String listarElectronico(Model model) {
		
		List<Electronico> lista=serviceElec.listarElectronico();
		
		model.addAttribute("lista", lista);
		
		return "listaElectronico";
		
	}
	
	@GetMapping("/formulario")
	public String formularioElectronico(Model model) {
		
		Electronico electronico =new Electronico();
		
		model.addAttribute("electronico", electronico);
		
		return "formularioElectronico";
		
	}
	
	@PostMapping("/insertar")
	public String insertarElectronico(@Valid @ModelAttribute("electronico")Electronico electronico, BindingResult result) {
		
		if(result.hasErrors()) {
			return "formularioElectronico";
		}else {
			serviceElec.agregarElectronico(electronico);
			return "redirect:/electronico/listar";
		}
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarElectronico(@PathVariable("id")int id) {
		
		serviceElec.eliminarElectronico(id);
		
		return "redirect:/electronico/listar"; 
		
	}
	
	@GetMapping("/editar/{id}")
	public String editarElectronico(@PathVariable("id")int id, Model model) {
		
		Electronico electronico =serviceElec.electronicoById(id);
		model.addAttribute("electronico", electronico);
		
		return "formularioElectronico";
		
		
	}
}
