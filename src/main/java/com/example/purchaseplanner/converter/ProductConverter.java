package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.ProductDto;
import com.example.purchaseplanner.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductConverter implements BaseConverter<ProductDto, Product> {

    @Override
    public ProductDto convert(final Product product) {
        final ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setCategoryName(product.getCategory().getName());
        return productDto;
    }
}
