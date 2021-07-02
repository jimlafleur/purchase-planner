package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.GoodsDto;
import com.example.purchaseplanner.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class GoodsConverter {
    public GoodsDto convert(Product product) {
        return GoodsDto.builder()
                .name(product.getName())
                .coast(0)
                .count(0)
                .productId(product.getId())
                .build();
    }
}
