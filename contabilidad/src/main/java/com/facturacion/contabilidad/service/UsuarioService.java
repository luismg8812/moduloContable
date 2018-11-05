package com.facturacion.contabilidad.service;



import java.util.List;

import com.facturacion.contabilidad.model.Usuario;



public interface UsuarioService {

	Usuario save(Usuario usuario);

	Usuario getById(String usuarioId);

	List<Usuario> getByLogin(String login);

	List<Usuario> getByFiltros(String nombre, String login, String rol, String idenficacion);

	

}
