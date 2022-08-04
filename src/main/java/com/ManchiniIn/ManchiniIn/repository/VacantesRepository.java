package com.ManchiniIn.ManchiniIn.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ManchiniIn.ManchiniIn.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

	List<Vacante> findByEstatus(String estatus);
	List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(Integer destacado, String estatus);
	List<Vacante> findBySalarioBetweenOrderBySalarioDesc(Double s1, Double s2);
	List<Vacante> findByEstatusIn(String[] estatus);
}
