package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.converter.ProductConverter;
import com.example.purchaseplanner.dto.ProductDto;
import com.example.purchaseplanner.entity.Category;
import com.example.purchaseplanner.entity.Product;
import com.example.purchaseplanner.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductConverter productConverter;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(productConverter::convert)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") Product product) {
        return product;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product,
                              @RequestParam("categoryId") Category category) {
        product.setCategory(category);
        return productRepository.save(product);
    }

    @PutMapping("{id}")
    public Product editProduct(@PathVariable("id") Product productFromDb,
                               @RequestBody Product product) {
        BeanUtils.copyProperties(product, productFromDb, "id");
        return productRepository.save(productFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Product product) {
        productRepository.delete(product);
    }

}
