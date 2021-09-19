package com.example.purchaseplanner.entity;

import com.example.purchaseplanner.entity.base.BaseNamedEntity;
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
 * Категория товара
 */
@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseNamedEntity {
    /**
     * Описание категории
     */
    private String description;

    /**
     * Список продуктов {@link Product}, которые принадлежат данной категории
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
