package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.entity.Category;
import com.example.purchaseplanner.entity.Purchase;
import com.example.purchaseplanner.repository.PurchaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    PurchaseRepository purchaseRepository;

    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @PostMapping
    public Purchase addPurchase(@RequestBody Purchase purchase, @RequestParam("categoryId") Category category) {
        return purchaseRepository.save(purchase);
    }

    @GetMapping("{id}")
    public Purchase getPurchaseById(@PathVariable("id") Purchase purchase) {
        return purchase;
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
