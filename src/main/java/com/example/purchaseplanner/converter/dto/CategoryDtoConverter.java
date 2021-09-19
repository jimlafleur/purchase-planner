package com.example.purchaseplanner.converter.dto;

import com.example.purchaseplanner.dto.CategoryDto;
import com.example.purchaseplanner.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter implements BaseDtoConverter<Category, CategoryDto> {
    @Override
    public Category convert(final CategoryDto categoryDto) {
        final Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return category;
    }
}
