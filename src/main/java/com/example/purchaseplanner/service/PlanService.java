package com.example.purchaseplanner.service;

import com.example.purchaseplanner.converter.PlanConverter;
import com.example.purchaseplanner.dto.plan.BasePlanDto;
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

    public List<BasePlanDto> getAllPlans() {
        return planRepository
                .findAll()
                .stream()
                .map(planConverter::convert)
                .collect(Collectors.toList());
    }

}
