package com.dieg0code.microserviceproducts.models.dao;

import com.dieg0code.microserviceproducts.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDAO extends CrudRepository<Producto, Long> {
}
