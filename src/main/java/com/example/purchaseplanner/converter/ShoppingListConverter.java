package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.PurchaseDto;
import com.example.purchaseplanner.dto.ShoppingListDto;
import com.example.purchaseplanner.entity.ShoppingList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ShoppingListConverter {

    private final PurchaseConverter purchaseConverter;

    public ShoppingListDto convert(final ShoppingList shoppingList) {
        return ShoppingListDto.builder()
                .id(shoppingList.getId())
                .name(shoppingList.getName())
                .purchaseList(getPurchases(shoppingList))
                .build();
    }

    private List<PurchaseDto> getPurchases(final ShoppingList shoppingList) {
        return shoppingList
                .getPurchaseList()
                .stream()
                .map(purchaseConverter::convert)
                .collect(Collectors.toList());
    }
}
