package com.example.purchaseplanner.service;

import com.example.purchaseplanner.converter.ProductConverter;
import com.example.purchaseplanner.dto.ProductDto;
import com.example.purchaseplanner.entity.Purchase;
import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductConverter productConverter;

    public List<ProductDto> getProducts(final ShoppingList list) {
        return addPurchasesFromList(list, productRepository
                .findAll()
                .stream()
                .map(productConverter::convert)
                .collect(Collectors.toList()));
    }

    private List<ProductDto> addPurchasesFromList(final ShoppingList shoppingList, final List<ProductDto> productDtos) {
        shoppingList.getPurchaseList()
                .forEach(purchase ->
                        fillPurchaseFields(purchase, getProductByName(productDtos, purchase.getProduct().getName())));
        return productDtos;
    }

    private void fillPurchaseFields(final Purchase purchase, final ProductDto productDto) {
        productDto.setCount(purchase.getCount());
        productDto.setCoast(purchase.getCoast());
        productDto.setPurchaseId(purchase.getId());
    }

    private ProductDto getProductByName(final List<ProductDto> productDtos, final String productName) {
        return productDtos
                .stream()
                .filter(productDto -> productName.equals(productDto.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Продукт с именем '%s' не найден", productName)));
    }
}
