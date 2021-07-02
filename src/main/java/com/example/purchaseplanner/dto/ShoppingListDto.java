package com.example.purchaseplanner.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShoppingListDto {

    private int id;
    private String name;
    private List<PurchaseDto> purchaseList;

}
