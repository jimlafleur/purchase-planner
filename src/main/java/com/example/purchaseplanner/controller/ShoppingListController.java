package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.repository.ShoppingListRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lists")
public class ShoppingListController {
    @Autowired
    ShoppingListRepository shoppingListRepository;

    @GetMapping
    public List<ShoppingList> getAllLists() {
        return shoppingListRepository.findAll();
    }

    @GetMapping("{id}")
    public ShoppingList getListById(@PathVariable("id") ShoppingList shoppingList) {
        return shoppingList;
    }

    @PostMapping
    public ShoppingList addList(@RequestBody ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    @PutMapping("{id}")
    public ShoppingList editList(@PathVariable("id") ShoppingList listFromDb,
                                 @RequestBody ShoppingList shoppingList) {
        BeanUtils.copyProperties(shoppingList, listFromDb, "id");
        return shoppingListRepository.save(listFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteList(@PathVariable("id") ShoppingList shoppingList) {
        shoppingListRepository.delete(shoppingList);
    }
}
