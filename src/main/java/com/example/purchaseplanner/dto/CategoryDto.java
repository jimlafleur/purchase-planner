package com.example.purchaseplanner.dto;

import com.example.purchaseplanner.dto.base.BaseNamedDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Категория товара
 */
@Getter
@Setter
@NoArgsConstructor
public class CategoryDto extends BaseNamedDto {
    /**
     * Описание категории
     */
    private String description;

    private List<ProductDto> products = new ArrayList<>();
}
