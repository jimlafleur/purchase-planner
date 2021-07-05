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
import java.util.Optional;
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
        Optional<Purchase> optional = getPurchaseByProductName(list, product);
        if (optional.isPresent()) {
            final Purchase oldPurchase = optional.get();
            oldPurchase.setCount(oldPurchase.getCount() + 1);
            return purchaseRepository.save(oldPurchase);
        }
        purchase.setShoppingList(list);
        purchase.setProduct(product);
        return purchaseRepository.save(purchase);
    }

    private Optional<Purchase> getPurchaseByProductName(ShoppingList list, Product product) {
        return list.getPurchaseList()
                .stream()
                .filter(purchase -> checkName(purchase, product.getName()))
                .findFirst();
    }

    private boolean checkName(Purchase purchase, String productName) {
        String name = purchase.getProduct().getName();
        return name != null && !name.isBlank() && name.equals(productName);
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
