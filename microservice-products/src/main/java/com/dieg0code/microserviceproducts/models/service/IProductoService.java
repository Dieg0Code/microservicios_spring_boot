package com.dieg0code.microserviceproducts.models.service;

import com.dieg0code.microserviceproducts.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();

    public Producto findById(Long id);

    public Producto save(Producto producto);

    public void deletById(Long id);

}
