package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.converter.entity.ProductConverter;
import com.example.purchaseplanner.dto.ProductDto;
import com.example.purchaseplanner.entity.Category;
import com.example.purchaseplanner.entity.Product;
import com.example.purchaseplanner.repository.ProductRepository;
import com.example.purchaseplanner.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ProductDto getProductById(@PathVariable("id") Product product) {
        return productConverter.convert(product);
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto,
                                 @RequestParam("categoryId") Category category) {
        return productService.addProduct(productDto, category);
    }

    @PutMapping("{id}")
    public ProductDto editProduct(@PathVariable("id") Product productFromDb,
                                  @RequestBody ProductDto productDto,
                                  @RequestParam("categoryId") Category category) {
        return productService.editProduct(productFromDb, productDto, category);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Product product) {
        productRepository.delete(product);
    }

}
