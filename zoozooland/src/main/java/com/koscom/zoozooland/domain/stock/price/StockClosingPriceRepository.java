package com.koscom.zoozooland.domain.stock.price;

import com.koscom.zoozooland.domain.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockClosingPriceRepository extends JpaRepository<StockClosingPrice, Long> {

    public List<StockClosingPrice> findAllByStock(Stock stock);
}
