package com.example.purchaseplanner.entity.plan;

public enum PlanType {

    SINGLE("Единичный план"),
    WEEKLY("Недельный план"),
    PERIODIC("Периодический план");

    private final String description;


    PlanType(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
