package com.example.purchaseplanner.dto.plan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SinglePlanDto extends BasePlanDto{
    /**
     * Дата плана
     */
    private Date planDate;
}
