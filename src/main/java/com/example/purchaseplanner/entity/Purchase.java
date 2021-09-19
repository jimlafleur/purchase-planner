package com.example.purchaseplanner.entity;

import com.example.purchaseplanner.entity.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * Список покупок
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "shopping_list_id")
    private ShoppingList shoppingList;
}
