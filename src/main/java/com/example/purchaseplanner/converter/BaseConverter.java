package com.example.purchaseplanner.converter;

/**
 * Базовый интерфейс для всех конвертеров
 */
public interface BaseConverter<T, R> {
    T convert(R entity);
}
