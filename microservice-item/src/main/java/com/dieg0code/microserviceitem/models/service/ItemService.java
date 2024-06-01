package com.dieg0code.microserviceitem.models.service;

import com.dieg0code.microserviceitem.models.Item;
import com.dieg0code.microserviceitem.models.Producto;

import java.util.List;

public interface ItemService {

    public List<Item> findAll();
    public Item findById(Long id, Integer cantidad);
    public Producto save(Producto producto);
    public Producto update(Producto producto, Long id);
    public void delete(Long id);

}
