package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.entity.Category;
import com.example.purchaseplanner.entity.Purchase;
import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("purchases")
public class PurchaseController {

    @Autowired
    PurchaseRepository purchaseRepository;

    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @GetMapping("{id}")
    public Purchase getPurchaseById(@PathVariable("id") Purchase purchase) {
        return purchase;
    }

    @PostMapping
    public Purchase addPurchase(@RequestParam("categoryId") Category category,
                                @RequestParam("listId") ShoppingList list,
                                @RequestBody Purchase purchase) {
        purchase.setCategory(category);
        purchase.setShoppingList(list);
        return purchaseRepository.save(purchase);
    }

    @PutMapping("{id}")
    public Purchase editPurchase(@PathVariable("id") Purchase purchaseFromDb,
                                 @RequestBody Purchase purchase,
                                 @RequestParam("categoryId") Category category) {
        purchaseFromDb.setName(purchase.getName());
        purchaseFromDb.setCount(purchase.getCount());
        purchaseFromDb.setCoast(purchase.getCoast());
        purchaseFromDb.setCategory(category);
        return purchaseRepository.save(purchaseFromDb);
    }

    @DeleteMapping("{id}")
    public void deletePurchase(@PathVariable("id") Purchase purchase) {
        purchaseRepository.delete(purchase);
    }

}
