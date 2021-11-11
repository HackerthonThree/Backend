package com.koscom.zoozooland.web.dto;

import com.koscom.zoozooland.domain.stock.Stock;
import lombok.Getter;

@Getter
public class StockListResponseDto {
    private final Long stockCode;
    private final String stockName;

    public StockListResponseDto(Stock entity) {
        this.stockCode = entity.getStockCode();
        this.stockName = entity.getStockName();
    }
}
