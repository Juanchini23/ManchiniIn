package com.ManchiniIn.ManchiniIn.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ManchiniIn.ManchiniIn.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacanteService{

	private List<Vacante> lista=null;
	
	public VacantesServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		this.lista = new LinkedList<Vacante>();
		
		try {
			Vacante vacante1=new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Programador Java");
			vacante1.setDescripcion("Se busca programador java");
			vacante1.setSalario(12500.0);
			vacante1.setFecha(sdf.parse("08-02-2015"));
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");
			
			Vacante vacante2=new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Programador JavaScript");
			vacante2.setDescripcion("Se busca programador javascript");
			vacante2.setSalario(8100.0);
			vacante2.setFecha(sdf.parse("10-02-2015"));
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");
			
			Vacante vacante3=new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Programador C");
			vacante3.setDescripcion("Se busca programador C");
			vacante3.setSalario(5000.0);
			vacante3.setFecha(sdf.parse("01-03-2015"));
			vacante3.setDestacado(1);
			
			Vacante vacante4=new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Programador PHP");
			vacante4.setDescripcion("Se busca programador PHP");
			vacante4.setSalario(7800.0);
			vacante4.setFecha(sdf.parse("09-07-2015"));
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa3.png");
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public List<Vacante> buscarTodas() {
		
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer id) {
		Vacante aux=null;
		
		for (Vacante i : lista) {
			if(i.getId().equals(id)) {
				aux=i;
				break;
			}
		}
		
		return aux;
	}

	@Override
	public void guardar(Vacante vacante) {
		
		lista.add(vacante);
	}

	@Override
	public List<Vacante> buscarDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer idELiminar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
