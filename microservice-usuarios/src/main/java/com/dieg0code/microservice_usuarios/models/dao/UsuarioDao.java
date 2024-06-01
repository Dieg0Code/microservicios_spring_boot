package com.dieg0code.microservice_usuarios.models.dao;

import com.dieg0code.microservice_usuarios.models.entity.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

    public Usuario findByUsername(String username);
}
