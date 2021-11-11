package com.koscom.zoozooland.domain.stock;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@ToString
public class Stock {

    @Id
    @Column(nullable = false)
    private Long stockCode;

    @Column
    private String stockName;

    @Builder
    public Stock(Long stockCode, String stockName) {
        this.stockCode = stockCode;
        this.stockName = stockName;
    }
}
