package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.ProductDto;
import com.example.purchaseplanner.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductDto convert(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .categoryName(product.getCategory().getName())
                .categoryId(product.getCategory().getId())
                .build();
    }
}
