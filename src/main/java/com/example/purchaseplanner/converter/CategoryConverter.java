package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.CategoryDto;
import com.example.purchaseplanner.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements BaseConverter<CategoryDto, Category> {
    @Override
    public CategoryDto convert(final Category category) {
        final CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        return categoryDto;
    }
}
