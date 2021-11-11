package com.koscom.zoozooland.web.dto;

import com.koscom.zoozooland.domain.account.transaction.Transaction;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TransactionListResponseDto {
    private final boolean transType;
    private final LocalDateTime transDate;
    private final int qty;
    private final Long amt;

    public TransactionListResponseDto(Transaction entity) {
        this.transType = entity.isTransType();
        this.transDate = entity.getTransDate();
        this.qty = entity.getQty();
        this.amt = entity.getAmount();
    }
}
