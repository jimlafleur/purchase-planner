package com.example.purchaseplanner.controller;

import com.example.purchaseplanner.dto.plan.BasePlanDto;
import com.example.purchaseplanner.dto.plan.CommonPlanDto;
import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.entity.plan.BasePlan;
import com.example.purchaseplanner.service.PlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("plans")
@AllArgsConstructor
public class PlanController {

    private final PlanService planService;

    @GetMapping
    public List<CommonPlanDto> getAllPlans() {
        return planService.getAllPlans();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BasePlan addPlan(@RequestBody BasePlanDto plan,
                            @RequestParam("listId") ShoppingList shoppingList) {
        return planService.addPlan(plan, shoppingList);
    }
}
