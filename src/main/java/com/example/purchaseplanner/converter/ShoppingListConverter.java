package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.ShoppingListDto;
import com.example.purchaseplanner.entity.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ShoppingListConverter {

    @Autowired
    PurchaseConverter purchaseConverter;

    public ShoppingListDto convert(final ShoppingList shoppingList) {
        final ShoppingListDto shoppingListDto = new ShoppingListDto();
        shoppingListDto.setId(shoppingList.getId());
        shoppingListDto.setName(shoppingList.getName());
        shoppingListDto.setPurchaseList(shoppingList
                .getPurchaseList()
                .stream()
                .map(purchaseConverter::convert)
                .collect(Collectors.toList()));
        return shoppingListDto;
    }
}
