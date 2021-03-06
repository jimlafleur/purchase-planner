package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.dto.GoodsDto;
import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("goods")
@AllArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    @GetMapping
    public List<GoodsDto> getGoods(@RequestParam("listId") ShoppingList list,
                                   @RequestParam String nameForSearch) {
        return goodsService.getGoods(list, nameForSearch);
    }
}
