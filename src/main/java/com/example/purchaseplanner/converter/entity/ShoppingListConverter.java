package com.example.purchaseplanner.converter.entity;

import com.example.purchaseplanner.dto.PurchaseDto;
import com.example.purchaseplanner.dto.ShoppingListDto;
import com.example.purchaseplanner.entity.ShoppingList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ShoppingListConverter implements BaseEntityConverter<ShoppingListDto, ShoppingList> {

    private final PurchaseConverter purchaseConverter;

    @Override
    public ShoppingListDto convert(final ShoppingList shoppingList) {
        final ShoppingListDto shoppingListDto = new ShoppingListDto();
        shoppingListDto.setId(shoppingList.getId());
        shoppingListDto.setName(shoppingList.getName());
        shoppingListDto.setPurchaseList(getPurchases(shoppingList));
        return shoppingListDto;
    }

    private List<PurchaseDto> getPurchases(final ShoppingList shoppingList) {
        return shoppingList
                .getPurchaseList()
                .stream()
                .map(purchaseConverter::convert)
                .collect(Collectors.toList());
    }
}
