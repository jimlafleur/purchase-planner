package com.example.purchaseplanner.converter.entity;

import com.example.purchaseplanner.dto.ProductDto;
import com.example.purchaseplanner.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductConverter implements BaseEntityConverter<ProductDto, Product> {

    @Override
    public ProductDto convert(final Product product) {
        final ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setCategoryName(product.getCategory().getName());
        return productDto;
    }
}
