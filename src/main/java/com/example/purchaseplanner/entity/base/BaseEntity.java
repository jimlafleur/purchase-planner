package com.example.purchaseplanner.entity.base;

import lombok.Getter;

import javax.persistence.*;

/**
 * Базовый класс сущности
 */
@MappedSuperclass
@Getter
public abstract class BaseEntity {
    /**
     * Идентификатор сущности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected int id;
}
