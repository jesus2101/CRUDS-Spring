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
import net.braval.service.IEmpresaService;

@Controller
@RequestMapping(value="/empresa")
public class EmpresaController {
	
	@Autowired
	private IEmpresaService empresaService;
	
	@GetMapping("/listarEmpresas")
	public String listarEmpresas(Model model) {
		
		List<Empresa> listaEmpresas=empresaService.listarEmpresas();
		model.addAttribute("listaEmpresas", listaEmpresas);
		
		return "listaEmpresas";
	}
	
	@GetMapping("/formEmpresa")
	public String formularioEmpresa(Model model) {
		
		Empresa empresa=new Empresa();
		
		model.addAttribute("empresa", empresa);
		
		return "formularioEmpresa";
	}
	
	
	@PostMapping("/crear")
	public String crearEmpresa(@Valid @ModelAttribute("empresa") Empresa empresa, BindingResult result) {
		
		if(result.hasErrors()) {
			return "formularioEmpresa";
		}else {
			empresaService.registrar(empresa);
			return "redirect:/empresa/listarEmpresas";
		}
		
	}
	
	@GetMapping("/editar/{id}")
	public String editarEmpresa(@PathVariable("id")int id,Model model) {
		
		Empresa empresa=empresaService.actualizar(id);
		
		model.addAttribute("empresa",empresa);
		
		return "formularioEmpresa";
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String editarEmpresa(@PathVariable("id")int id) {
		
		empresaService.eliminar(id);
		
		return "redirect:/empresa/listarEmpresas";
		
	}

}
