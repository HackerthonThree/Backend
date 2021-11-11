package com.koscom.zoozooland.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.nickname = ?1")
    public User findByNickname(String nickname);

    public boolean existsByNickname(String nickname);

    public boolean existsByIdAndPassword(String id, String password);

    @Query("select u from User u where u.id = ?1 and u.password = ?2")
    public User findByIdAndPassword(String id, String password);
}
