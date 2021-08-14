package com.example.purchaseplanner.dto.plan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PeriodicPlanDto extends BasePlanDto{
    /**
     * Дата начала исполнения плана
     */
    private Date startDate;

    /**
     * Периодичность (количество дней между повторными исполнениями)
     */
    private int periodicity;
}
