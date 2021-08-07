package com.example.purchaseplanner.entity;

import com.example.purchaseplanner.entity.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Категория товара
 */
@Entity
@Table(name = "purchases")
@Getter
@Setter
@NoArgsConstructor
public class Purchase extends BaseEntity {
    /**
     * Количество
     */
    private int count;

    /**
     * Стоимость покупки
     */
    private int coast;

    /**
     * Продукт, к которому относится покупка
     */
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * Список покупок
     */
    @ManyToOne
    @JoinColumn(name = "shopping_list_id")
    private ShoppingList shoppingList;
}
