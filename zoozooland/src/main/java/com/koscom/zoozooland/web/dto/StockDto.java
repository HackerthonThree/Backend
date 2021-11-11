package com.koscom.zoozooland.web.dto;

import com.koscom.zoozooland.domain.stock.Stock;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class StockDto {
    private final Long stockCode;
    private final String stockName;

    public StockDto(Stock entity) {
        this.stockCode = entity.getStockCode();
        this.stockName = entity.getStockName();
    }
}
