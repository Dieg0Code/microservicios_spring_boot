package com.dieg0code.microserviceproducts.models.service;

import com.dieg0code.microserviceproducts.models.dao.ProductoDAO;
import com.dieg0code.microserviceproducts.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private ProductoDAO productoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return productoDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    @Transactional
    public void deletById(Long id) {
        productoDAO.deleteById(id);
    }
}
