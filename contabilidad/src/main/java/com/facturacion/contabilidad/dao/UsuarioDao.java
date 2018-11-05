package com.facturacion.contabilidad.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.contabilidad.model.Usuario;



public interface UsuarioDao extends JpaRepository<Usuario, Long>{

}
