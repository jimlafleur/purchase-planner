package com.example.purchaseplanner.service;

import com.example.purchaseplanner.converter.CategoryConverter;
import com.example.purchaseplanner.converter.CategoryDtoConverter;
import com.example.purchaseplanner.dto.CategoryDto;
import com.example.purchaseplanner.entity.Category;
import com.example.purchaseplanner.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;
    private final CategoryDtoConverter categoryDtoConverter;

    public List<CategoryDto> getAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryConverter::convert)
                .collect(Collectors.toList());
    }

    public Category addCategory(CategoryDto categoryDto) {
        return categoryRepository.save(categoryDtoConverter.convert(categoryDto));
    }


}
