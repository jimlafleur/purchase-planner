package com.example.purchaseplanner.dto;

import java.util.List;

public class ShoppingListDto {

    private int id;
    private String name;
    private List<PurchaseDto> purchaseList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PurchaseDto> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<PurchaseDto> purchaseList) {
        this.purchaseList = purchaseList;
    }
}
