package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.PurchaseDto;
import com.example.purchaseplanner.entity.Purchase;
import org.springframework.stereotype.Component;

@Component
public class PurchaseConverter {
    public PurchaseDto convert(final Purchase purchase) {

        return PurchaseDto.builder()
                .name(purchase.getProduct().getName())
                .coast(purchase.getCoast())
                .count(purchase.getCount())
                .productId(purchase.getProduct().getId())
                .purchaseId(purchase.getId())
                .listId(purchase.getShoppingList().getId())
                .isBought(purchase.isBought())
                .categoryName(purchase.getProduct().getCategory().getName())
                .build();
    }
}
