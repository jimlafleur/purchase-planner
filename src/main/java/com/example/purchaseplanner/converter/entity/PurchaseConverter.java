package com.example.purchaseplanner.converter.entity;

import com.example.purchaseplanner.dto.PurchaseDto;
import com.example.purchaseplanner.entity.Purchase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PurchaseConverter implements BaseEntityConverter<PurchaseDto, Purchase> {

    private final ProductConverter productConverter;

    @Override
    public PurchaseDto convert(final Purchase purchase) {
        final PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setName(purchase.getProduct().getName());
        purchaseDto.setCoast(purchase.getCoast());
        purchaseDto.setCount(purchase.getCount());
        purchaseDto.setId(purchase.getProduct().getId());
        purchaseDto.setCategoryName(purchase.getProduct().getCategory().getName());
        purchaseDto.setShoppingListId(purchase.getShoppingList().getId());
        return purchaseDto;
    }
}
