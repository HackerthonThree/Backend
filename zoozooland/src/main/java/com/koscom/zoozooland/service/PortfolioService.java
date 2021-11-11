package com.koscom.zoozooland.service;

import com.koscom.zoozooland.domain.account.AccountRepository;
import com.koscom.zoozooland.domain.stock.StockRepository;
import com.koscom.zoozooland.domain.stock.price.StockClosingPriceRepository;
import com.koscom.zoozooland.domain.user.UserRepository;
import com.koscom.zoozooland.web.dto.AccountResponseDto;
import com.koscom.zoozooland.web.dto.StockClosingPriceListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioService {
    private final StockClosingPriceRepository stockClosingPriceRepository;
    private final StockRepository stockRepository;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    // 종목별 종가 데이터 조회
    @Transactional
    public List<StockClosingPriceListResponseDto> getStockPrice(Long stockCode) {
        System.out.println(stockRepository.findById(stockCode).get().toString());
        return stockClosingPriceRepository.findAllByStock(stockRepository.findById(stockCode).get()).stream()
                .map(StockClosingPriceListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 개인 계좌 조회회
    @Transactional
    public List<AccountResponseDto> getAccount(Long userId) {
        return accountRepository.findAllByUser(userRepository.findById(userId).get()).stream()
                .map(AccountResponseDto::new)
                .collect(Collectors.toList());
    }
}
