package com.ManchiniIn.ManchiniIn.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ManchiniIn.ManchiniIn.model.Usuario;
import com.ManchiniIn.ManchiniIn.repository.CategoriasRepository;
import com.ManchiniIn.ManchiniIn.repository.UsuariosRepository;
import com.ManchiniIn.ManchiniIn.service.IUsuariosService;

@Service
@Primary
public class UsuariosServiceJpa implements IUsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepo;
	
	@Override
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
	}

	@Override
	public void eliminar(Integer idUsuario) {
		usuariosRepo.deleteById(idUsuario);
		
	}

	@Override
	public List<Usuario> buscarTodos() {
		
		return usuariosRepo.findAll();
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		
		return usuariosRepo.findByUsername(username);
	}

}
