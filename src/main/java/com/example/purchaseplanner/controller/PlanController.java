package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.dto.plan.BasePlanDto;
import com.example.purchaseplanner.entity.plan.BasePlan;
import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.repository.PlanRepository;
import com.example.purchaseplanner.service.PlanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("plans")
@AllArgsConstructor
public class PlanController {

    private final PlanService planService;
    private final PlanRepository planRepository;

    @GetMapping
    public List<BasePlanDto> getAllPlans() {
        return planService.getAllPlans();
    }

    @PostMapping
    public BasePlan addPlan(@RequestBody BasePlan basePlan,
                            @RequestParam("listId") ShoppingList shoppingList) {
        basePlan.setShoppingList(shoppingList);
        return planRepository.save(basePlan);
    }
}
