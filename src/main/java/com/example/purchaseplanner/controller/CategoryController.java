package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.converter.CategoryConverter;
import com.example.purchaseplanner.dto.CategoryDto;
import com.example.purchaseplanner.entity.Category;
import com.example.purchaseplanner.repository.CategoryRepository;
import com.example.purchaseplanner.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;
    private final CategoryConverter categoryConverter;

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("{id}")
    public CategoryDto getCategoryById(@PathVariable("id") Category category) {
        return categoryConverter.convert(category);
    }

    @PostMapping
    public Category addCategory(@RequestBody CategoryDto category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("{id}")
    public Category editCategory(@PathVariable("id") Category categoryFromDb,
                                 @RequestBody Category category) {
        BeanUtils.copyProperties(category, categoryFromDb, "id");
        return categoryRepository.save(categoryFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable("id") Category category) {
        categoryRepository.delete(category);
    }
}
