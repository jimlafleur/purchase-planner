package com.example.purchaseplanner.repository;

import com.example.purchaseplanner.entity.plan.BasePlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<BasePlan, Integer> {
}
