package com.koscom.zoozooland.web.dto;

import com.koscom.zoozooland.domain.stock.Stock;
import com.koscom.zoozooland.domain.stock.price.StockClosingPrice;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class StockClosingPriceListResponseDto {

    private final Stock stock;
    private final Long endCost;
    private final LocalDateTime date;

    public StockClosingPriceListResponseDto(StockClosingPrice entity) {
        this.stock = entity.getStock();
        this.endCost = entity.getEndCost();
        this.date = entity.getDate();
    }
}
