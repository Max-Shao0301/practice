package com.user.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean check(String account, String password) {
        UserVO userAccount = userRepository.findByAccount(account);
        if (userAccount == null) {
            return false;
        }
        if (account.equals(userAccount.getAccount()) && password.equals(userAccount.getPassword())) {
            return true;
        }else {
            return false;
        }
    }

    public List<UserVO> findAll() {
        List<UserVO> list = userRepository.findUsers();
        return list;
    }
}
