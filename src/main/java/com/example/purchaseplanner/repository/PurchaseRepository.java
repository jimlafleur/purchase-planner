package com.example.purchaseplanner.repository;

import com.example.purchaseplanner.entity.Purchase;
import org.springframework.data.repository.CrudRepository;


public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {

}
