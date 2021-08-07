package com.example.purchaseplanner.entity.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

/**
 * Базовый класс именованной сущности
 */
@MappedSuperclass
@Getter
@Setter
public class BaseNamedEntity extends BaseEntity {
    /**
     * Наименование сущности
     */
    protected String name;
}
