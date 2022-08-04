package com.ManchiniIn.ManchiniIn.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ManchiniIn.ManchiniIn.model.Categoria;


@Service
public class CategoriasServiceImpl implements ICategoriaService {

	private List<Categoria> lista = null;

	public CategoriasServiceImpl() {

		this.lista = new LinkedList<Categoria>();
		
		Categoria categoria1 = new Categoria();
		categoria1.setId(1);
		categoria1.setNombre("Programador");
		categoria1.setDescripcion("Para vacantes de programadores");
		lista.add(categoria1);
		
		Categoria categoria2 = new Categoria();
		categoria2.setId(2);
		categoria2.setNombre("Contador");
		categoria2.setDescripcion("Para vacantes de contadores");
		lista.add(categoria2);
		
		Categoria categoria3 = new Categoria();
		categoria3.setId(3);
		categoria3.setNombre("Tester QA");
		categoria3.setDescripcion("Para vacantes de Testers QA");
		lista.add(categoria3);
	}

	@Override
	public void guardar(Categoria categoria) {
		lista.add(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Categoria aux = null;

		for (Categoria i : lista) {
			if (i.getId().equals(idCategoria)) {
				aux = i;
				break;
			}
		}

		return aux;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
