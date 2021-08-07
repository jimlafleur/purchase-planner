package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.plan.BasePlanDto;
import com.example.purchaseplanner.dto.plan.SinglePlanDto;
import com.example.purchaseplanner.entity.plan.BasePlan;
import org.springframework.stereotype.Component;

@Component
public class PlanConverter implements BaseConverter<BasePlanDto, BasePlan> {

    @Override
    public BasePlanDto convert(final BasePlan basePlan) {
        final BasePlanDto basePlanDto = new SinglePlanDto();
//        planDto.setDate(plan.getDate());
        basePlanDto.setId(basePlan.getId());
//        planDto.setIsPeriodic(plan.getIsPeriodic());
//        planDto.setPeriodicity(plan.getPeriodicity());
        basePlanDto.setShoppingListId(basePlan.getShoppingList().getId());
        basePlanDto.setShoppingListName(basePlan.getShoppingList().getName());
        return basePlanDto;
    }
}
