package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.PurchaseDto;
import com.example.purchaseplanner.entity.Purchase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PurchaseConverter implements BaseConverter<PurchaseDto, Purchase> {

    private final ProductConverter productConverter;

    @Override
    public PurchaseDto convert(final Purchase purchase) {
        final PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setName(purchase.getProduct().getName());
        purchaseDto.setCoast(purchase.getCoast());
        purchaseDto.setCount(purchase.getCount());
        purchaseDto.setId(purchase.getProduct().getId());
        purchaseDto.setProduct(productConverter.convert(purchase.getProduct()));
        purchaseDto.setShoppingListId(purchase.getShoppingList().getId());
        return purchaseDto;
    }
}
