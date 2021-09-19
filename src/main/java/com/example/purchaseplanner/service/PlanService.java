package com.example.purchaseplanner.service;

import com.example.purchaseplanner.converter.entity.PlanConverter;
import com.example.purchaseplanner.converter.dto.PlanDtoConverter;
import com.example.purchaseplanner.dto.plan.BasePlanDto;
import com.example.purchaseplanner.dto.plan.CommonPlanDto;
import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.entity.plan.BasePlan;
import com.example.purchaseplanner.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;
    private final PlanConverter planConverter;
    private final PlanDtoConverter planDtoConverter;

    public List<CommonPlanDto> getAllPlans() {
        return planRepository
                .findAll()
                .stream()
                .map(planConverter::convert)
                .collect(Collectors.toList());
    }

    public CommonPlanDto addPlan(final BasePlanDto planDto, final ShoppingList shoppingList) {
        final BasePlan plan = planDtoConverter.convert(planDto);
        plan.setShoppingList(shoppingList);
        return planConverter.convert(planRepository.save(plan));
    }

}
