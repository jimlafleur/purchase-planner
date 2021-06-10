package com.example.purchaseplanner.repository;

import com.example.purchaseplanner.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {
}
