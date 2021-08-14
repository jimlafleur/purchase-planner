package com.example.purchaseplanner.dto.plan;

import com.example.purchaseplanner.dto.base.BaseNamedDto;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SinglePlanDto.class, name = "SINGLE"),
        @JsonSubTypes.Type(value = PeriodicPlanDto.class, name = "PERIODIC"),
        @JsonSubTypes.Type(value = WeeklyPlanDto.class, name = "WEEKLY")
})
public abstract class BasePlanDto extends BaseNamedDto {
    private int shoppingListId;
    private String shoppingListName;

    private String planType;
}
