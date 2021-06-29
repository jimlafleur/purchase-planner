package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.GoodsDto;
import com.example.purchaseplanner.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class GoodsConverter {
    public GoodsDto convert(Product product) {
        GoodsDto dto = new GoodsDto();
        dto.setName(product.getName());
        dto.setCoast(0);
        dto.setCount(0);
        dto.setProductId(product.getId());

        return dto;
    }
}
