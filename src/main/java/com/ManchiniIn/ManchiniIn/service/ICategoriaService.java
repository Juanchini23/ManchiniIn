package com.ManchiniIn.ManchiniIn.service;

import java.util.*;

import org.springframework.data.domain.*;

import com.ManchiniIn.ManchiniIn.model.Categoria;

public interface ICategoriaService {

	void guardar(Categoria categoria);
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Integer idCategoria);
	void eliminar(Integer idCategoria);
	Page<Categoria> buscarTodas(Pageable page);
}
