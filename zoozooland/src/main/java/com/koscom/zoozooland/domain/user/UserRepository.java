package com.koscom.zoozooland.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.nickname = ?1")
    public User findByNickname(String nickname);
}
