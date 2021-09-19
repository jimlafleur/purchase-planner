package com.example.purchaseplanner.converter.dto;

import com.example.purchaseplanner.dto.plan.BasePlanDto;
import com.example.purchaseplanner.dto.plan.PeriodicPlanDto;
import com.example.purchaseplanner.dto.plan.SinglePlanDto;
import com.example.purchaseplanner.dto.plan.WeeklyPlanDto;
import com.example.purchaseplanner.entity.plan.BasePlan;
import com.example.purchaseplanner.entity.plan.PeriodicPlan;
import com.example.purchaseplanner.entity.plan.SinglePlan;
import com.example.purchaseplanner.entity.plan.WeeklyPlan;
import com.example.purchaseplanner.exception.PurchaseException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static com.example.purchaseplanner.entity.plan.PlanType.*;

@Component
public class PlanDtoConverter implements BaseDtoConverter<BasePlan, BasePlanDto> {

    @Override
    public BasePlan convert(final BasePlanDto planDto) {
        return getConverter(planDto).apply(planDto);
    }

    public BasePlan getSinglePlan(final BasePlanDto basePlanDto) {
        final SinglePlan plan = new SinglePlan();
        final SinglePlanDto planDto = (SinglePlanDto) basePlanDto;
        plan.setPlanDate(planDto.getPlanDate());
        plan.setName(planDto.getName());
        plan.setPlanType(SINGLE);
        return plan;
    }

    public BasePlan getWeeklyPlan(final BasePlanDto basePlanDto) {
        final WeeklyPlan plan = new WeeklyPlan();
        final WeeklyPlanDto planDto = (WeeklyPlanDto) basePlanDto;
        plan.setMonday(planDto.isMonday());
        plan.setTuesday(planDto.isTuesday());
        plan.setWednesday(planDto.isWednesday());
        plan.setThursday(planDto.isThursday());
        plan.setFriday(planDto.isFriday());
        plan.setSaturday(planDto.isSaturday());
        plan.setSunday(planDto.isSunday());
        plan.setName(planDto.getName());
        plan.setPlanType(WEEKLY);

        return plan;
    }

    public BasePlan getPeriodicPlan(final BasePlanDto basePlanDto) {
        final PeriodicPlan plan = new PeriodicPlan();
        final PeriodicPlanDto planDto = (PeriodicPlanDto) basePlanDto;
        plan.setStartDate(planDto.getStartDate());
        plan.setPeriodicity(planDto.getPeriodicity());
        plan.setName(planDto.getName());
        plan.setPlanType(PERIODIC);
        return plan;
    }

    private Map<String, Function<BasePlanDto, BasePlan>> getConverterMap() {
        final Map<String, Function<BasePlanDto, BasePlan>> converterMap = new HashMap<>();
        converterMap.put(SINGLE.name(), this::getSinglePlan);
        converterMap.put(WEEKLY.name(), this::getWeeklyPlan);
        converterMap.put(PERIODIC.name(), this::getPeriodicPlan);
        return converterMap;
    }

    private Function<BasePlanDto, BasePlan> getConverter(final BasePlanDto planDto) {
        return Optional
                .ofNullable(getConverterMap().get(planDto.getPlanType()))
                .orElseThrow(() -> new PurchaseException(""));
    }
}
