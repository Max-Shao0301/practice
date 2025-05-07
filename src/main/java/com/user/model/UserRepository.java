package com.user.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserVO, Integer> {

    UserVO findByAccount(String account);
}
