package com.facturacion.contabilidad.service.impl;



import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.facturacion.contabilidad.dao.UsuarioDao;
import com.facturacion.contabilidad.model.Rol;
import com.facturacion.contabilidad.model.Usuario;
import com.facturacion.contabilidad.service.UsuarioService;



@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private static Logger log = Logger.getLogger(UsuarioServiceImpl.class);

	@Autowired
	protected UsuarioDao usuarioDao;

	@Override
	public Usuario save(Usuario usuario) {
		log.info("usuario a guardar:"+usuario);
		return usuarioDao.save(usuario);
	}

	@Override
	public Usuario getById(String usuarioId) {
		Optional<Usuario> list = usuarioDao.findById(Long.valueOf(usuarioId));
		return list.get();
	}

	@Override
	public List<Usuario> getByLogin(String login) {
		Usuario usuario= new Usuario(); 
		usuario.setLogin(login);
		Example<Usuario> example = Example.of(usuario);
		List<Usuario> list=  usuarioDao.findAll(example);
		return list;
	}

	@Override
	public List<Usuario> getByFiltros(String nombre, String login, String rol, String idenficacion) {
		Usuario usuario= new Usuario(); 
		if(login!=null && !login.isEmpty()) {
			usuario.setLogin(login);
		}
		if(nombre!=null && !nombre.isEmpty()) {
			usuario.setNombre(nombre);
		}
		if(rol!=null && !rol.isEmpty()) {
			Rol rolObj = new Rol();
			rolObj.setRolId(new Long(rol));
			usuario.setRolId(rolObj);
		}
		if(idenficacion!=null && !idenficacion.isEmpty()) {
			usuario.setNombre(idenficacion);
		}
		
		Example<Usuario> example = Example.of(usuario);
		return  usuarioDao.findAll(example);
	}
	
}
