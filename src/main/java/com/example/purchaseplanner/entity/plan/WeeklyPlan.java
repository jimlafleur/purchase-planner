package com.example.purchaseplanner.entity.plan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Недельный план. Исполняется каждую неделю в указанные дни
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class WeeklyPlan extends BasePlan {
    /**
     * Флаг исполнения плана в понедельник
     */
    private boolean isMonday;

    /**
     * Флаг исполнения плана во вторник
     */
    private boolean isTuesday;

    /**
     * Флаг исполнения плана в среду
     */
    private boolean isWednesday;

    /**
     * Флаг исполнения плана в четверг
     */
    private boolean isThursday;

    /**
     * Флаг исполнения плана в пятницу
     */
    private boolean isFriday;

    /**
     * Флаг исполнения плана в субботу
     */
    private boolean isSaturday;

    /**
     * Флаг исполнения плана в воскресенье
     */
    private boolean isSunday;
}
