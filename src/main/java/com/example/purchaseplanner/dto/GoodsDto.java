package com.example.purchaseplanner.dto;

import com.example.purchaseplanner.dto.base.BaseNamedDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Товар
 */
@Getter
@Setter
@NoArgsConstructor
public class GoodsDto extends BaseNamedDto {
    /**
     * Количество
     */
    private int count;

    /**
     * Идентификатор продукта
     */
    private int productId;

    /**
     * Идентификатор покупки
     */
    private int purchaseId;
}
