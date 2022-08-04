package com.ManchiniIn.ManchiniIn.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.*;

import com.ManchiniIn.ManchiniIn.model.Vacante;

public interface IVacanteService {

	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer id);
	void guardar(Vacante vacante);
	List<Vacante> buscarDestacadas();
	void eliminar(Integer idELiminar);
	List<Vacante> buscarByExample(Example<Vacante> example);
	public Page<Vacante> buscarTodas(Pageable page);
}
