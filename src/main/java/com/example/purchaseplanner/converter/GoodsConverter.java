package com.example.purchaseplanner.converter;

import com.example.purchaseplanner.dto.GoodsDto;
import com.example.purchaseplanner.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class GoodsConverter implements BaseConverter<GoodsDto, Product> {
    @Override
    public GoodsDto convert(final Product product) {
        final GoodsDto goodsDto = new GoodsDto();
        goodsDto.setName(product.getName());
        goodsDto.setProductId(product.getId());
        return goodsDto;
    }
}
