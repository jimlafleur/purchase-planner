package com.example.purchaseplanner.dto;

import com.example.purchaseplanner.dto.base.BaseNamedDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Список покупок
 */
@Getter
@Setter
@NoArgsConstructor
public class ShoppingListDto extends BaseNamedDto {
    /**
     * Список покупок
     */
    private List<PurchaseDto> purchaseList = new ArrayList<>();
}
