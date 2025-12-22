package com.common.dto;

import java.math.BigDecimal;

public class AccountResponseDTO {
    //1>Attributes
    private Long accountId;
    private Long userId;
    private String accountType;
    private BigDecimal balance;

    //2>Default Constructor
    public AccountResponseDTO() {
    }
    //3>Parameterized Constructor

    public AccountResponseDTO(Long accountId, Long userId, String accountType, BigDecimal balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.accountType = accountType;
        this.balance = balance;
    }

    //4>Getter & Setter

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    //5>toString()

    @Override
    public String toString() {
        return "AccountResponseDTO{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                '}';
    }
}
