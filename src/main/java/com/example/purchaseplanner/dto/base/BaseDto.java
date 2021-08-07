package com.example.purchaseplanner.dto.base;

import lombok.Getter;
import lombok.Setter;

/**
 * Базовый класс для всех DTO
 */
@Getter
@Setter
public abstract class BaseDto {
    /**
     * Идентификатор сущности в базе данных
     */
    protected int id;
}
