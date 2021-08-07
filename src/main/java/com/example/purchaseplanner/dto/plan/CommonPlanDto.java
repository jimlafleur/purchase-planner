package com.example.purchaseplanner.dto.plan;

import com.example.purchaseplanner.dto.base.BaseNamedDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


/**
 * Общий dto для всех типов планов (для отображения на UI в списке планов)
 */
@Getter
@Setter
@NoArgsConstructor
public class CommonPlanDto extends BaseNamedDto {
    /**
     * Общи
     */
    private int shoppingListId;

    /**
     * Общи
     */
    private String shoppingListName;

    /**
     * Общи
     */
    private Date date;

}
