package com.dieg0code.microserviceproducts.controllers;

import com.dieg0code.microserviceproducts.models.entity.Producto;
import com.dieg0code.microserviceproducts.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    // ****************************************************************************************
    // ****************************************************************************************
    // ****************************************************************************************

    @GetMapping("/listar")
    public List<Producto> getAllProducts() {
        return productoService.findAll();
    }

    // ****************************************************************************************
    // ****************************************************************************************
    // ****************************************************************************************

    @GetMapping("/ver/{id}")
    public Producto getProductById(@PathVariable("id") Long id) {
        return productoService.findById(id);
    }
}
