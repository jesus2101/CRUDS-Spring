package net.braval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.braval.model.Serie;
import net.braval.service.ISerieService;

@Controller
@RequestMapping(value="serie")
public class SerieController {
	
	@Autowired
	private ISerieService servSerie;
	
	
	@GetMapping("/formSerie")
	public String formularioSerie(Model model) {
		
		return "formularioSerie";
		
	}
	
	
	@GetMapping("/listar")
	public String tablaSeries(Model model) {
		
		List<Serie> lista=servSerie.listarSeries();
		
		model.addAttribute("series", lista);
		
		return "listaSeries";
	}
	

}
