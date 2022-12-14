package com.ManchiniIn.ManchiniIn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ManchiniIn.ManchiniIn.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
}
