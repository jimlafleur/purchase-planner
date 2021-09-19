package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.converter.entity.ShoppingListConverter;
import com.example.purchaseplanner.dto.ShoppingListDto;
import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.repository.ShoppingListRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("lists")
@AllArgsConstructor
public class ShoppingListController {

    private final ShoppingListRepository shoppingListRepository;
    private final ShoppingListConverter shoppingListConverter;

    @GetMapping
    public List<ShoppingListDto> getAllLists() {
        return shoppingListRepository
                .findAll()
                .stream()
                .map(shoppingListConverter::convert)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ShoppingListDto getListById(@PathVariable("id") ShoppingList shoppingList) {
        return shoppingListConverter.convert(shoppingList);
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
