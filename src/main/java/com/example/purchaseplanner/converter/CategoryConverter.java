package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.CategoryDto;
import com.example.purchaseplanner.dto.ProductDto;
import com.example.purchaseplanner.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CategoryConverter implements BaseConverter<CategoryDto, Category> {
    private final ProductConverter productConverter;

    @Override
    public CategoryDto convert(final Category category) {
        final CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setProducts(getProducts(category));
        return categoryDto;
    }

    private List<ProductDto> getProducts(final Category category) {
        return category
                .getProducts()
                .stream()
                .map(productConverter::convert)
                .collect(Collectors.toList());
    }
}
