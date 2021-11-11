package com.koscom.zoozooland.domain.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query("select s from Stock s where s.stockName = ?1")
    public Stock findByStockName(String stockName);

//    @Query("select s from Stock s")
//    public List<Stock> findAllStock();
}
