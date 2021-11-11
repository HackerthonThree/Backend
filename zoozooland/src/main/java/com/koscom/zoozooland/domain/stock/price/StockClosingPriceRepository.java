package com.koscom.zoozooland.domain.stock.price;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockClosingPriceRepository extends JpaRepository<StockClosingPrice, Long> {
}
