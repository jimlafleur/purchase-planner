package com.example.purchaseplanner.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ShoppingListDto {

    private int id;
    private String name;
    private List<PurchaseDto> purchaseList;

}
