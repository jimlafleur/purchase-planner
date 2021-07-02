package com.example.purchaseplanner.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDto {

    private String name;
    private String categoryName;
    private int categoryId;

}
