package com.example.purchaseplanner.dto;

import com.example.purchaseplanner.dto.base.BaseNamedDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Продукт
 */
@Getter
@Setter
@NoArgsConstructor
public class ProductDto extends BaseNamedDto {
    /**
     * Категория товара, к которой относится продукт
     */
    private CategoryDto category;
}
