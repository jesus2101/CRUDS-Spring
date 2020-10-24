package net.braval.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.braval.model.Serie;
import net.braval.repository.ISerieRepository;


@Service
public class SerieServiceImpl implements ISerieService {

	@Autowired
	private ISerieRepository repoSerie;
	
	@Override
	public List<Serie> listarSeries() {
		
		List<Serie> listaSeries=repoSerie.findAll();
		
		
		return listaSeries;
	}

	@Override
	public void registrar(Serie serie) {
		
		repoSerie.save(serie);

	}

	@Override
	public void eliminar(Integer id) {
		
		repoSerie.deleteById(id);

	}

	@Override
	public Serie actualizarSerie(Integer id) {
		Optional<Serie> optional=repoSerie.findById(id);
		
		if(optional.isPresent()) {
			Serie serie=optional.get();
			
			return serie;
		}
		   
		   
		return null;
	}

}
