package com.dieg0code.microserviceitem.models.service;

import com.dieg0code.microserviceitem.models.Item;

import java.util.List;

public interface ItemService {

    public List<Item> findAll();
    public Item findById(Long id, Integer cantidad);

}
