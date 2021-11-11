package com.koscom.zoozooland.web.dto;

import com.koscom.zoozooland.domain.account.Account;
import com.koscom.zoozooland.domain.user.User;
import lombok.Getter;

@Getter
public class AccountResponseDto {
    private final User user;
    private final String stockName;
    private final Long qty;

    public AccountResponseDto(Account entity) {
        this.user = entity.getUser();
        this.stockName = entity.getStockName();
        this.qty = entity.getQty();
    }
}
