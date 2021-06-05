package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.entity.Purchase;
import com.example.purchaseplanner.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PurchaseController {

    @Autowired
    PurchaseRepository purchaseRepository;

    @GetMapping("/purchases")
    public String getAllPurchases(Model model) {
        model.addAttribute("purchases", purchaseRepository.findAll());
        return "purchases";
    }

    @PostMapping("/purchases")
    public String addMessage(@RequestParam String name,
                             @RequestParam int count,
                             @RequestParam double coast,
                             Model model) {
        Purchase message = new Purchase(name, count, coast);

        purchaseRepository.save(message);
        model.addAttribute("purchases", purchaseRepository.findAll());
        return "purchases";
    }

}
