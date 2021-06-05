package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.entity.Category;
import com.example.purchaseplanner.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public String getAllPurchases(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categories";
    }

    @PostMapping("/categories")
    public String addMessage(@RequestParam String name,
                             @RequestParam String description,
                             Model model) {
        Category category = new Category(name, description);

        categoryRepository.save(category);
        model.addAttribute("categories", categoryRepository.findAll());
        return "categories";
    }
}
