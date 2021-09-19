package com.example.purchaseplanner.converter.dto;

import com.example.purchaseplanner.converter.BaseConverter;
import com.example.purchaseplanner.dto.base.BaseDto;
import com.example.purchaseplanner.entity.base.BaseEntity;

/**
 * Базовый интерфейс для конвертеров из сущности базы данных {@link BaseEntity} в DTO {@link BaseDto}
 */
public interface BaseDtoConverter<T extends BaseEntity, R extends BaseDto> extends BaseConverter<T, R> {
    T convert(R entity);
}
