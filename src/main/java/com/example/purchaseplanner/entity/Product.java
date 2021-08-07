package com.example.purchaseplanner.entity;

import com.example.purchaseplanner.entity.base.BaseNamedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Продукт
 */
@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseNamedEntity {
    /**
     * Категория товара
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
