package com.example.purchaseplanner.entity.plan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Единичный план. Исполняется один раз в дату {@link #planDate}
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class SinglePlan extends BasePlan {
    /**
     * Дата плана
     */
    private Date planDate;
}
