package com.facturacion.contabilidad.controller;


import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.contabilidad.model.Usuario;
import com.facturacion.contabilidad.service.UsuarioService;

@RestController
public class UsuarioController {
	
	private static Logger log = Logger.getLogger(UsuarioController.class);
	
	@Autowired
	protected UsuarioService usuarioService;

	@RequestMapping(value="/getUsuarioByLogin", method=RequestMethod.GET )
	@CrossOrigin
	public Usuario getUsuarioByLogin(@RequestParam("login") String login) {
		List<Usuario> usuario= usuarioService.getByLogin(login);
		return usuario.isEmpty()?null:usuario.get(0);
	}
}