package com.dieg0code.microserviceitem.models.service;

import com.dieg0code.microserviceitem.clients.ProductoClientRest;
import com.dieg0code.microserviceitem.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
@Primary
public class ItemServiceFeignImpl implements  ItemService{

    @Autowired
    private ProductoClientRest feignClient;

    @Override
    public List<Item> findAll() {
        return feignClient.getAllProducts().stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(feignClient.getProductById(id), cantidad);
    }
}
