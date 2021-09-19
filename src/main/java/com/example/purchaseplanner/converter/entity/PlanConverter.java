package com.example.purchaseplanner.converter.entity;

import com.example.purchaseplanner.dto.plan.CommonPlanDto;
import com.example.purchaseplanner.entity.plan.BasePlan;
import com.example.purchaseplanner.entity.plan.SinglePlan;
import com.example.purchaseplanner.exception.PurchaseException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PlanConverter implements BaseEntityConverter<CommonPlanDto, BasePlan> {

    @Override
    public CommonPlanDto convert(final BasePlan basePlan) {
        final CommonPlanDto commonPlanDto = new CommonPlanDto();
        commonPlanDto.setId(basePlan.getId());
        commonPlanDto.setName(basePlan.getName());
        commonPlanDto.setNearestDate(getNearestDate(basePlan));
        commonPlanDto.setShoppingListId(basePlan.getShoppingList().getId());
        commonPlanDto.setShoppingListName(basePlan.getShoppingList().getName());
        commonPlanDto.setPlanType(basePlan.getPlanType().getDescription());
        return commonPlanDto;
    }

    private Date getNearestDate(final BasePlan plan) {
        switch (plan.getPlanType()) {
            case SINGLE:
                return getNearestDateForSinglePlan(plan);
            case WEEKLY:
                return getNearestDateForWeeklyPlan(plan);
            case PERIODIC:
                return getNearestDateForPeriodicPlan(plan);
            default:
                throw new PurchaseException("");

        }
    }

    private Date getNearestDateForSinglePlan(final BasePlan plan) {
        return ((SinglePlan) plan).getPlanDate();
    }

    private Date getNearestDateForWeeklyPlan(final BasePlan plan) {
        return new Date();
    }

    private Date getNearestDateForPeriodicPlan(final BasePlan plan) {
        return new Date();
    }
}
