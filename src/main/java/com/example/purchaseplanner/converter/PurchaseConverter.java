package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.PurchaseDto;
import com.example.purchaseplanner.entity.Purchase;
import org.springframework.stereotype.Component;

@Component
public class PurchaseConverter {
    public PurchaseDto convert(final Purchase purchase) {
        final PurchaseDto dto = new PurchaseDto();

        dto.setName(purchase.getProduct().getName());
        dto.setCoast(purchase.getCoast());
        dto.setCount(purchase.getCount());
        dto.setProductId(purchase.getProduct().getId());
        dto.setPurchaseId(purchase.getId());
        dto.setListId(purchase.getShoppingList().getId());
        dto.setBought(purchase.isBought());
        dto.setCategoryName(purchase.getProduct().getCategory().getName());

        return dto;
    }
}
