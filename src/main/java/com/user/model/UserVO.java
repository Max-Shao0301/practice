package com.user.model;


import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

@DynamicInsert
@Entity
@Table(name="user")
public class UserVO {

    @Id
    @Column(name="userid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name="account")
    private String account;

    @Column(name="password")
    private String password;

    public UserVO() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
