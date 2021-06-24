package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.ProductDto;
import com.example.purchaseplanner.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductDto convert(Product product) {
        ProductDto dto = new ProductDto();
        dto.setName(product.getName());
        dto.setCoast(0);
        dto.setCount(0);
        dto.setProductId(product.getId());

        return dto;
    }
}
