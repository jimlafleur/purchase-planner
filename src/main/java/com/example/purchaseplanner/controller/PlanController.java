package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.entity.Plan;
import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("plans")
@AllArgsConstructor
public class PlanController {

    private final PlanRepository planRepository;

    @GetMapping
    public List<Plan> getAllCategories() {
        return planRepository.findAll();
    }

    @PostMapping
    public Plan addPlan(@RequestBody Plan plan,
                        @RequestParam("listId") ShoppingList shoppingList) {
        plan.setList(shoppingList);
        return planRepository.save(plan);
    }
}
