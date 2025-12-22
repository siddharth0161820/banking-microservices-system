package com.common.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class AccountRequestDTO {
    //1>Attributes

    @NotEmpty(message = "User Id should not be null")
    private Long userId;
    @NotEmpty
    @Size(max = 51,message ="Please verify the account type" )
    private String accountType;
    @DecimalMin(value = "3.00")
    private BigDecimal balance;

    //2>Default Constructor
    public AccountRequestDTO() {
    }
    //3>Parameterized Constructor

    public AccountRequestDTO(Long userId, String accountType, BigDecimal balance) {
        this.userId = userId;
        this.accountType = accountType;
        this.balance = balance;
    }


    //4>Getter & Setter

    public @NotEmpty(message = "User Id should not be null") Long getUserId() {
        return userId;
    }

    public void setUserId(@NotEmpty(message = "User Id should not be null") Long userId) {
        this.userId = userId;
    }

    public @NotEmpty @Size(max = 51, message = "Please verify the account type") String getAccountType() {
        return accountType;
    }

    public void setAccountType(@NotEmpty @Size(max = 51, message = "Please verify the account type") String accountType) {
        this.accountType = accountType;
    }

    public @DecimalMin(value = "3.00") BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(@DecimalMin(value = "3.00") BigDecimal balance) {
        this.balance = balance;
    }


    //5>toString()

    @Override
    public String toString() {
        return "AccountRequestDTO{" +
                "userId=" + userId +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                '}';
    }
}
