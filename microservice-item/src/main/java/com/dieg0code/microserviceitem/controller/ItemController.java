package com.dieg0code.microserviceitem.controller;

import com.dieg0code.microserviceitem.models.Item;
import com.dieg0code.microserviceitem.models.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    @Qualifier("serviceFeign")
    private ItemService itemService;

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
        return itemService.findById(id, cantidad);
    }

}
