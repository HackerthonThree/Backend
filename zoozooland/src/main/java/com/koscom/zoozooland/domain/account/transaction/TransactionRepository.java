package com.koscom.zoozooland.domain.account.transaction;

import com.koscom.zoozooland.domain.stock.Stock;
import com.koscom.zoozooland.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("select t from Transaction t where t.stock.stockCode = ?1 and t.user.userId = ?2")
    public List<Transaction> findAllByStockAndUser(Long stockId, Long userId);

    public boolean existsTransactionByUserAndStock(User user, Stock stock);

    public List<Transaction> findAllByUserAndStock(User user, Stock stockCode);
}
