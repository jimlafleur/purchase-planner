package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.ProductDto;
import com.example.purchaseplanner.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductDto convert(Product product) {
        ProductDto dto = new ProductDto();
        dto.setName(product.getName());
        dto.setCategoryName(product.getCategory().getName());
        dto.setCategoryId(product.getCategory().getId());

        return dto;
    }
}
