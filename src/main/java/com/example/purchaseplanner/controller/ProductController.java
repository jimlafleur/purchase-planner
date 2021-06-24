package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.dto.ProductDto;
import com.example.purchaseplanner.entity.Product;
import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.repository.ProductRepository;
import com.example.purchaseplanner.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts(@RequestParam("listId") ShoppingList list) {
//        return productRepository.findAll();
        return productService.getProducts(list);
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") Product product) {
        return product;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
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
