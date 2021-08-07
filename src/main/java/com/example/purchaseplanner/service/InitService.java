package com.example.purchaseplanner.service;

import com.example.purchaseplanner.entity.Category;
import com.example.purchaseplanner.entity.Product;
import com.example.purchaseplanner.repository.CategoryRepository;
import com.example.purchaseplanner.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class InitService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public void initProducts() {
        try (Stream<String> stream = Files.lines(Paths.get("src\\main\\resources\\defaultProducts.txt"))) {
            final List<String> lines = stream.collect(Collectors.toList());
            Category currentCategory = null;
            Product currentProduct;
            boolean newCategory = true;
            for (String line : lines) {
                if ("#".equals(line)) {
                    newCategory = true;
                    continue;
                }
                if (newCategory) {
                    currentCategory = new Category();
                    currentCategory.setName(line);
                    currentCategory.setDescription(line);
                    categoryRepository.save(currentCategory);
                    newCategory = false;
                } else if (currentCategory != null) {
                    currentProduct = new Product();
                    currentProduct.setName(line);
                    currentProduct.setCategory(currentCategory);
                    productRepository.save(currentProduct);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
