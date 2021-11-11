//package com.koscom.zoozooland.web.controller;
//
//import com.koscom.zoozooland.domain.account.transaction.Transaction;
//import com.koscom.zoozooland.domain.account.transaction.TransactionRepository;
//import com.koscom.zoozooland.domain.stock.Stock;
//import com.koscom.zoozooland.domain.stock.StockRepository;
//import com.koscom.zoozooland.domain.stock.price.StockClosingPrice;
//import com.koscom.zoozooland.domain.stock.price.StockClosingPriceRepository;
//import com.koscom.zoozooland.domain.user.User;
//import com.koscom.zoozooland.domain.user.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDateTime;
//
//@RequiredArgsConstructor
//@RestController
//public class TempController {
//    private final StockClosingPriceRepository stockClosingPriceRepository;
//    private final StockRepository stockRepository;
//    private final UserRepository userRepository;
//    private final TransactionRepository transactionRepository;
//
//    @GetMapping("/")
//    public StockClosingPrice temp() {
//        Stock stock = Stock.builder()
//                .stockCode(35214L)
//                .stockName("삼성전자")
//                .build();
//
//        User user = User.builder()
//                .nickname("주형일")
//                .brokerage("KB증권")
//                .accountNumber("1234567890")
//                .build();
//
//        stockRepository.save(stock);
//
//        stockClosingPriceRepository.save(StockClosingPrice.builder()
//                        .stock(stock)
//                        .endCost(30000L)
//                        .build());
//
//        userRepository.save(user);
//
//        transactionRepository.save(Transaction.builder()
//                        .amount(30000L)
//                        .qty(50)
//                        .stock(stock)
//                        .transDate(LocalDateTime.now())
//                        .transType(true)
//                        .user(user)
//                        .build());
//
//        return stockClosingPriceRepository.findById(1L).get();
//    }
//
////    @GetMapping("/temp")
////    public Stock getStock(@RequestParam String stockName) {
////        System.out.println(stockRepository.findByStockName(stockName).toString());
////        return stockRepository.findByStockName(stockName);
////    }
////
////    @GetMapping("/temp2")
////    public User getUser(@RequestParam String nickname) {
////        System.out.println(userRepository.findByNickname(nickname));
////        return userRepository.findByNickname(nickname);
////    }
////
////    @GetMapping("/temp3")
////    public User getUserById(@RequestParam String id) {
////        System.out.println(userRepository.findById(1L).toString());
////        return userRepository.findById(Long.parseLong(id)).get();
////    }
//}
