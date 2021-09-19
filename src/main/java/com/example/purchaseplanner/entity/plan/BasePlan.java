package com.example.purchaseplanner.entity.plan;


import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.entity.base.BaseNamedEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Базовый класс сущности План
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@Entity
public abstract class BasePlan extends BaseNamedEntity {
    /**
     * Список покупок, к которому относится данный план
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "shopping_list_id")
    protected ShoppingList shoppingList;

    /**
     * Тип плана
     */
    protected PlanType planType;
}
