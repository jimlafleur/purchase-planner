package com.example.purchaseplanner.converter;

public interface BaseConverter<T, R> {
    T convert(R entity);
}
