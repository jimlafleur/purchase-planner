package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.dto.GoodsDto;
import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping
    public List<GoodsDto> getAllProducts(@RequestParam("listId") ShoppingList list) {
        return goodsService.getProducts(list);
    }
}
