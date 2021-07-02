package com.example.purchaseplanner.service;

import com.example.purchaseplanner.converter.GoodsConverter;
import com.example.purchaseplanner.dto.GoodsDto;
import com.example.purchaseplanner.entity.Purchase;
import com.example.purchaseplanner.entity.ShoppingList;
import com.example.purchaseplanner.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodsService {

    private final ProductRepository productRepository;
    private final GoodsConverter goodsConverter;

    public List<GoodsDto> getGoods(final ShoppingList list, final String nameForSearch) {
        List<GoodsDto> products = getGoods(nameForSearch);
        addPurchasesParamsFromList(products, list);
        return products;
    }

    /**
     * Возвращает список товаров, которые подходят под критерии поиска по имени
     *
     * @param nameForSearch имя товара (часть имени) для поиска
     * @return список товаров
     */
    private List<GoodsDto> getGoods(final String nameForSearch) {
        return productRepository
                .findAll()
                .stream()
                .filter(product -> product.getName().contains(nameForSearch.trim()))
                .map(goodsConverter::convert)
                .collect(Collectors.toList());
    }

    /**
     * Заполняет поля dto товара {@link GoodsDto} данными из покупки {@link Purchase}
     *
     * @param goods        список товаров
     * @param shoppingList список покупок
     */
    private void addPurchasesParamsFromList(final List<GoodsDto> goods, final ShoppingList shoppingList) {
        shoppingList
                .getPurchaseList()
                .forEach(purchase -> addPurchaseParams(purchase, goods));
    }

    /**
     * Для переданной покупки находит соответствующий товар из списка переданных и, если такой товар найден, заполняет
     * его поля данными из покупки
     *
     * @param purchase покупка
     * @param goods    список товаров
     */
    private void addPurchaseParams(final Purchase purchase, final List<GoodsDto> goods) {
        goods.stream()
                .filter(goodsDto -> purchase.getProduct().getName().equals(goodsDto.getName()))
                .findFirst()
                .ifPresent(goodsDto -> fillPurchaseFields(purchase, goodsDto));
    }

    /**
     * Заполняет поля dto товара {@link GoodsDto} данными из покупки {@link Purchase}
     *
     * @param purchase покупка
     * @param goodsDto dto товара
     */
    private void fillPurchaseFields(final Purchase purchase, final GoodsDto goodsDto) {
        goodsDto.setCount(purchase.getCount());
        goodsDto.setCoast(purchase.getCoast());
        goodsDto.setPurchaseId(purchase.getId());
    }
}
