package com.koscom.zoozooland.domain.account;

import com.koscom.zoozooland.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    public List<Account> findAllByUser(User user);
}
