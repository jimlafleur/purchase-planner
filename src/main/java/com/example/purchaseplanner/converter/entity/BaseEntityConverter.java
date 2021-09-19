package com.example.purchaseplanner.converter.entity;

import com.example.purchaseplanner.converter.BaseConverter;
import com.example.purchaseplanner.dto.base.BaseDto;
import com.example.purchaseplanner.entity.base.BaseEntity;

/**
 * Базовый интерфейс для конвертеров из DTO {@link BaseDto} в сущность базы данных {@link BaseEntity}
 */
public interface BaseEntityConverter<T extends BaseDto, R extends BaseEntity> extends BaseConverter<T, R> {
    T convert(R entity);
}


