package com.dieg0code.microserviceitem.clients;

import com.dieg0code.microserviceitem.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-products", url = "localhost:8081")
public interface ProductoClientRest {

    @GetMapping("/listar")
    public List<Producto> getAllProducts();

    @GetMapping("/ver/{id}")
    public Producto getProductById(@PathVariable Long id);

}
