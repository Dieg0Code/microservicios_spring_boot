package com.dieg0code.microserviceitem.controller;

import com.dieg0code.microserviceitem.models.Item;
import com.dieg0code.microserviceitem.models.Producto;
import com.dieg0code.microserviceitem.models.service.ItemService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.springframework.http.ResponseEntity.ok;


@RestController
public class ItemController {

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    @Qualifier("serviceRestTemplate")
    private ItemService itemService;

    @Value("${configuracion.mensaje}")
    private String texto;

    // ******************************************************************************************
    // ******************************************************************************************
    // ******************************************************************************************

    @GetMapping("/listar")
    public List<Item> getAllItems() {
        return itemService.findAll();
    }

    // ******************************************************************************************
    // ******************************************************************************************
    // ******************************************************************************************

    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item getItemById(@PathVariable("id") Long id, @PathVariable("cantidad") Integer cantidad) {
        return circuitBreakerFactory.create("items")
                .run(() -> itemService.findById(id, cantidad), e -> metodoAlternativo(id, cantidad));
    }

    @CircuitBreaker(name = "items", fallbackMethod = "metodoAlternativo")
    @GetMapping("/ver1/{id}/cantidad/{cantidad}")
    public Item getItemById1(@PathVariable("id") Long id, @PathVariable("cantidad") Integer cantidad) {
        return itemService.findById(id, cantidad);
    }

    @TimeLimiter(name = "items", fallbackMethod = "metodoAlternativo")
    @GetMapping("/ver2/{id}/cantidad/{cantidad}")
    public CompletableFuture<Item> getItemById2(@PathVariable("id") Long id, @PathVariable("cantidad") Integer cantidad) {
        return CompletableFuture.supplyAsync(() -> itemService.findById(id, cantidad));
    }

    public Item metodoAlternativo(Long id, Integer cantidad) {
        Item item = new Item();
        Producto producto = new Producto();

        item.setCantidad(cantidad);
        producto.setId(id);
        producto.setNombre("Camara Sony");
        producto.setPrecio(500.00);
        item.setProducto(producto);

        return item;
    }

    // ******************************************************************************************
    // ******************************************************************************************
    // ******************************************************************************************

    @GetMapping("/obtener-config")
    public ResponseEntity<?> obtenerConfig() {
        Map<String, String> json = new HashMap<>();
        json.put("texto", texto);
        return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
    }

}
