package com.example.purchaseplanner.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PurchaseDto {

    private String name;
    private int count;
    private double coast;
    private int productId;
    private int purchaseId;
    private int listId;
    private String categoryName;
    private boolean isBought;

}
