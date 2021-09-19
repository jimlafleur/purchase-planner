package com.example.purchaseplanner.entity;

import com.example.purchaseplanner.entity.base.BaseNamedEntity;
import com.example.purchaseplanner.entity.plan.BasePlan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Список покупок
 */
@Entity
@Table(name = "shopping_lists")
@Getter
@Setter
@NoArgsConstructor
public class ShoppingList extends BaseNamedEntity {
    /**
     * Список покупок
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shoppingList")
    private List<Purchase> purchaseList = new ArrayList<>();

    /**
     * Список планов, связанных с этим списком покупок
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shoppingList")
    private List<BasePlan> basePlans = new ArrayList<>();
}
