package com.koscom.zoozooland.domain.account.transaction;

import com.koscom.zoozooland.domain.stock.Stock;
import com.koscom.zoozooland.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn
    private Stock stock;

    @ManyToOne
    @JoinColumn
    private User user;

    @Column
    private boolean transType;

    @Column
    private LocalDateTime transDate;

    @Column
    private int qty;

    @Column
    private Long amount;

    @Builder
    public Transaction(Stock stock, User user, boolean transType, LocalDateTime transDate, int qty, Long amount) {
        this.stock = stock;
        this.user = user;
        this.transType = transType;
        this.transDate = transDate;
        this.qty = qty;
        this.amount = amount;
    }
}
