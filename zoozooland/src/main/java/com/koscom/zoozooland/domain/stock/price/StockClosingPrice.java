package com.koscom.zoozooland.domain.stock.price;

import com.koscom.zoozooland.domain.stock.Stock;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class StockClosingPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockClosingPriceId;

    @ManyToOne
    @JoinColumn
    private Stock stock;

    @Column
    private Long endCost;

    @Column
    private LocalDateTime date;

    @Builder
    public StockClosingPrice(Stock stock, Long endCost, LocalDateTime date) {
        this.stock = stock;
        this.endCost = endCost;
        this.date = date;
    }
}
