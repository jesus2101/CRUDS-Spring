package net.braval.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.braval.model.Banda;
import net.braval.model.Genero;
import net.braval.service.IBandaService;
import net.braval.service.IGeneroService;

@Controller
@RequestMapping(value="/banda")
public class BandaController {
	
	@Autowired
	private IBandaService bandaService;
	
	@Autowired
	private IGeneroService generoService;
	
	@GetMapping("/listarB")
	public String listarBandas(Model model) {
		List<Banda> lista=bandaService.listarBandas();
		model.addAttribute("listaBandas", lista);
		return "listaBanda";
		
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id, RedirectAttributes atributes) {
		
		bandaService.eliminar(id);
		
		atributes.addFlashAttribute("msg", "Vacante Eliminada");
		return "redirect:/banda/listarB";
		//Para redireccionar es con los nombresen la clase en gett o request Mapping
	}
	
	@GetMapping("/crear")
	public String formCrearBanda(Model model){
	  Banda banda=new Banda();
	  List<Genero> generos=generoService.listar();
	  
	  model.addAttribute("banda", banda);  
	  model.addAttribute("generos", generos);
		
		return "formularioBanda";
	}
	
	@PostMapping("/registrar")
	public String registrarBanda(@Valid @ModelAttribute("banda") Banda banda, BindingResult resultadoValidacion) {
        System.out.println(banda);
		if(resultadoValidacion.hasErrors()) {
        	return "formularioBanda";
        }else {
        	bandaService.registrar(banda);
    		
    		return "redirect:/banda/listarB";
        }
		
		 
	}
	
	@GetMapping("/editar/{id}")
	public String editarBanda(@PathVariable("id")int id,Model mode) {
		
		Banda banda=bandaService.bandaPorId(id);
		List<Genero> generos=generoService.listar();
		mode.addAttribute("banda", banda);
		mode.addAttribute("generos",generos);
		
		return "formularioBanda";		
		
	}

}
