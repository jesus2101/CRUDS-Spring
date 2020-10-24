package net.braval.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.braval.model.Personaje;
import net.braval.repository.IPersonajeRepository;

@RestController
@RequestMapping("/personajeREST")
public class PersonaController {
	
	
	@Autowired
	private IPersonajeRepository repoPerso;
	
	
	@GetMapping("/all")
	public List<Personaje> getAll(){
		return repoPerso.findAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Personaje> save(@RequestBody Personaje persona) {
		Personaje obl=repoPerso.save(persona);
		return new ResponseEntity<Personaje>(obl,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Personaje> delete(@PathVariable Integer id){
        Optional<Personaje> optional=repoPerso.findById(id);
        if(optional.isPresent()) {
        	
        	repoPerso.deleteById(id);
        }else {
        	return new ResponseEntity<Personaje>(optional.get(),HttpStatus.INTERNAL_SERVER_ERROR);	
        }
        
        return new ResponseEntity<Personaje>(optional.get(),HttpStatus.OK);
		
		
	}

}
