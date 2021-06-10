package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.entity.Category;
import com.example.purchaseplanner.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("{id}")
    public Category getCategoryById(@PathVariable("id") Category category) {
        return category;
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("{id}")
    public Category editCategory(@PathVariable("id") Category categoryFromDb,
                                 @RequestBody Category category) {
        BeanUtils.copyProperties(category, categoryFromDb, "id");
        return categoryRepository.save(categoryFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteList(@PathVariable("id") Category category) {
        categoryRepository.delete(category);
    }
}
