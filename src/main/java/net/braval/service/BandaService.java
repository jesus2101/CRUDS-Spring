package net.braval.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.braval.model.Banda;
import net.braval.repository.IBandaRepository;

@Service
public class BandaService implements IBandaService{
	
	@Autowired
	private IBandaRepository bandaRepository;

	@Override
	public List<Banda> listarBandas() {
		// TODO Auto-generated method stub
		
		List<Banda> listaBandas=bandaRepository.findAll();
		
		return listaBandas;
	}

	@Override
	public void registrar(Banda banda) {
		bandaRepository.save(banda);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
		bandaRepository.deleteById(id);
		
	}

	@Override
	public Banda bandaPorId(Integer id) {
		
		Optional<Banda> optional=bandaRepository.findById(id);
		
		if(optional.isPresent()) {
			
			Banda banda=optional.get();
			
			return banda;
		}
		return null;
		
	}
	
	
	
}
	
	