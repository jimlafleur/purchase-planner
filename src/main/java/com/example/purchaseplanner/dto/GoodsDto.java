package com.example.purchaseplanner.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GoodsDto {
    private String name;
    private int count;
    private double coast;
    private int productId;
    private int purchaseId;
}
