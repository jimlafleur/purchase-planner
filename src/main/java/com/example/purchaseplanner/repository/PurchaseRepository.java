package com.example.purchaseplanner.repository;

import com.example.purchaseplanner.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
