package com.example.purchaseplanner.service;

import com.example.purchaseplanner.converter.GoodsConverter;
import com.example.purchaseplanner.dto.GoodsDto;
import com.example.purchaseplanner.entity.Purchase;
import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    GoodsConverter goodsConverter;

    public List<GoodsDto> getProducts(final ShoppingList list) {
        return addPurchasesFromList(list, productRepository
                .findAll()
                .stream()
                .map(goodsConverter::convert)
                .collect(Collectors.toList()));
    }

    private List<GoodsDto> addPurchasesFromList(final ShoppingList shoppingList, final List<GoodsDto> goodsDtos) {
        shoppingList.getPurchaseList()
                .forEach(purchase ->
                        fillPurchaseFields(purchase, getProductByName(goodsDtos, purchase.getProduct().getName())));
        return goodsDtos;
    }

    private void fillPurchaseFields(final Purchase purchase, final GoodsDto goodsDto) {
        goodsDto.setCount(purchase.getCount());
        goodsDto.setCoast(purchase.getCoast());
        goodsDto.setPurchaseId(purchase.getId());
    }

    private GoodsDto getProductByName(final List<GoodsDto> goodsDtos, final String productName) {
        return goodsDtos
                .stream()
                .filter(goodsDto -> productName.equals(goodsDto.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Продукт с именем '%s' не найден", productName)));
    }
}
