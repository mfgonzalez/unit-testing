package com.example.unittesting.controller;

import com.example.unittesting.data.ItemRepository;
import com.example.unittesting.model.Item;
import com.example.unittesting.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService service;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return service.retrieveHardcodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems() {
        return service.retrieveAllItems();
    }

}
