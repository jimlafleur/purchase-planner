package com.example.purchaseplanner.converter.dto;

import com.example.purchaseplanner.dto.ProductDto;
import com.example.purchaseplanner.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConverter implements BaseDtoConverter<Product, ProductDto> {
    @Override
    public Product convert(final ProductDto productDto) {
        final Product product = new Product();
        product.setName(productDto.getName());
        return product;
    }
}
