package com.example.unittesting.service;

import com.example.unittesting.data.ItemRepository;
import com.example.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public List<Item> retrieveAllItems() {
        List<Item> items = repository.findAll();
        for (Item item: items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }

    public Item retrieveHardcodedItem() {
        return new Item(1, "ball", 10, 100);
    }


}
