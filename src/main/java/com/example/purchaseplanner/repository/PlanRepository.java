package com.example.purchaseplanner.repository;

import com.example.purchaseplanner.entity.Category;
import com.example.purchaseplanner.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
}
