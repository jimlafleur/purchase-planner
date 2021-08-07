package com.example.purchaseplanner.dto.plan;

import com.example.purchaseplanner.dto.base.BaseNamedDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BasePlanDto extends BaseNamedDto {
    private int shoppingListId;
    private String shoppingListName;
}
