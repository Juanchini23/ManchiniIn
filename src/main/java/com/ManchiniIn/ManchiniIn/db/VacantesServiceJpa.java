package com.ManchiniIn.ManchiniIn.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ManchiniIn.ManchiniIn.model.Vacante;
import com.ManchiniIn.ManchiniIn.repository.VacantesRepository;
import com.ManchiniIn.ManchiniIn.service.IVacanteService;

@Service
@Primary
public class VacantesServiceJpa implements IVacanteService {

	@Autowired
	private VacantesRepository vacantesRepo;

	@Override
	public List<Vacante> buscarTodas() {

		return vacantesRepo.findAll();
	}

	@Override
	public Vacante buscarPorId(Integer id) {

		Optional<Vacante> op = vacantesRepo.findById(id);
		return op.orElse(null);

	}

	@Override
	public void guardar(Vacante vacante) {
		vacantesRepo.save(vacante);
	}

	@Override
	public List<Vacante> buscarDestacadas() {

		return vacantesRepo.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

	@Override
	public void eliminar(Integer idELiminar) {
		vacantesRepo.deleteById(idELiminar);
	}

	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		// TODO Auto-generated method stub
		return vacantesRepo.findAll(example);
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		
		return vacantesRepo.findAll(page);
	}
	

}
