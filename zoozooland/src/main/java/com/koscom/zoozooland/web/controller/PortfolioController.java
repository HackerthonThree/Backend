package com.koscom.zoozooland.web.controller;

import com.koscom.zoozooland.service.PortfolioService;
import com.koscom.zoozooland.web.dto.AccountResponseDto;
import com.koscom.zoozooland.web.dto.StockClosingPriceListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/portfolio/")
@RequiredArgsConstructor
@RestController
public class PortfolioController {

    private final PortfolioService portfolioService;

    // 종목별 종가 데이터 조회
    @GetMapping("/stock/price/{stockCode}")
    public List<StockClosingPriceListResponseDto> getStockPrice(@PathVariable Long stockCode) {
        return portfolioService.getStockPrice(stockCode);
    }

    // 개인별 계좌 조회
    @GetMapping("/account/{userId}")
    public List<AccountResponseDto> getAccount(@PathVariable Long userId) {
        return portfolioService.getAccount(userId);
    }
}
