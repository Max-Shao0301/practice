package com.user.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<UserVO, Integer> {

    UserVO findByAccount(String account);

    @Query(value="SELECT userid, account, password FROM user", nativeQuery = true)
    List<UserVO> findUsers();
}
