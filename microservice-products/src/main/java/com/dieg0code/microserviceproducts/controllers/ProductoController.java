package com.dieg0code.microserviceproducts.controllers;

import com.dieg0code.microserviceproducts.models.entity.Producto;
import com.dieg0code.microserviceproducts.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // ****************************************************************************************
    // ****************************************************************************************
    // ****************************************************************************************

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto createProduct(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    // ****************************************************************************************
    // ****************************************************************************************
    // ****************************************************************************************

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto updateProduct(@RequestBody Producto producto, @PathVariable("id") Long id) {
        Producto product = productoService.findById(id);
        product.setNombre(producto.getNombre());
        product.setPrecio(producto.getPrecio());
        return productoService.save(product);
    }

    // ****************************************************************************************
    // ****************************************************************************************
    // ****************************************************************************************

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id) {
        productoService.deletById(id);
    }
}
