package com.example.purchaseplanner.dto;

import com.example.purchaseplanner.dto.base.BaseNamedDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Покупка
 */
@Getter
@Setter
@NoArgsConstructor
public class PurchaseDto extends BaseNamedDto {
    /**
     * Количество
     */
    private int count;

    /**
     * Стоимость покупки
     */
    private int coast;

    /**
     * Идентификатор списка покупок
     */
    private int shoppingListId;

    /**
     * Продукт, к которому относится покупка
     */
    private ProductDto product;
}
