package com.example.purchaseplanner.dto.base;

import lombok.Getter;
import lombok.Setter;

/**
 * Базовый класс для всех DTO, имеющих имя
 */
@Getter
@Setter
public abstract class BaseNamedDto extends BaseDto {
    /**
     * Имя сущности
     */
    protected String name;
}
