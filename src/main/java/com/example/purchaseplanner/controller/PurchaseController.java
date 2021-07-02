package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.converter.PurchaseConverter;
import com.example.purchaseplanner.dto.PurchaseDto;
import com.example.purchaseplanner.entity.Product;
import com.example.purchaseplanner.entity.Purchase;
import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.repository.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("purchases")
@AllArgsConstructor
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseConverter purchaseConverter;

    @GetMapping
    public List<PurchaseDto> getAllPurchases() {
        return purchaseRepository
                .findAll()
                .stream()
                .map(purchaseConverter::convert)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public Purchase getPurchaseById(@PathVariable("id") Purchase purchase) {
        return purchase;
    }

    @PostMapping
    public Purchase addPurchase(@RequestParam("listId") ShoppingList list,
                                @RequestParam("productId") Product product,
                                @RequestBody Purchase purchase) {
        purchase.setShoppingList(list);
        purchase.setProduct(product);
        return purchaseRepository.save(purchase);
    }

    @PutMapping("{id}")
    public Purchase editPurchase(@PathVariable("id") Purchase purchaseFromDb,
                                 @RequestBody Purchase purchase) {
        purchaseFromDb.setCount(purchase.getCount());
        purchaseFromDb.setCoast(purchase.getCoast());
        return purchaseRepository.save(purchaseFromDb);
    }

    @DeleteMapping("{id}")
    public void deletePurchase(@PathVariable("id") Purchase purchase) {
        purchaseRepository.delete(purchase);
    }

}
