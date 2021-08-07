package com.example.purchaseplanner.entity.plan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Периодичный план. Начиная с даты {@link #startDate}, будет исполняться с периодичностью в {@link #periodicity} дней
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class PeriodicPlan extends BasePlan {
    /**
     * Дата начала исполнения плана
     */
    private Date startDate;

    /**
     * Периодичность (количество дней между повторными исполнениями)
     */
    private int periodicity;
}
