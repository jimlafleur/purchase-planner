package com.example.purchaseplanner.service;

import com.example.purchaseplanner.converter.dto.ProductDtoConverter;
import com.example.purchaseplanner.converter.entity.ProductConverter;
import com.example.purchaseplanner.dto.ProductDto;
import com.example.purchaseplanner.entity.Category;
import com.example.purchaseplanner.entity.Product;
import com.example.purchaseplanner.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final ProductDtoConverter productDtoConverter;

    public List<ProductDto> getAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(productConverter::convert)
                .collect(Collectors.toList());
    }

    public ProductDto addProduct(final ProductDto productDto,
                                 final Category category) {
        final Product product = productDtoConverter.convert(productDto);
        product.setCategory(category);
        return productConverter.convert(productRepository.save(product));
    }

    public ProductDto editProduct(final Product productFromDb,
                                  final ProductDto productDto,
                                  final Category category) {
        productFromDb.setName(productDto.getName());
        productFromDb.setCategory(category);
        return productConverter.convert(productRepository.save(productFromDb));
    }
}
