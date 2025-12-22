package com.common.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;

public class TransactionRequestDTO {
    //1>Attributes
    @NotNull(message = "Please provide the valid account id")
    private Long accountId;
    @Min(4)
    private BigDecimal amount;
    @NotEmpty(message = "Please provide the transaction type mode")
    private String transactionType;

    //2>Default Constructor
    public TransactionRequestDTO() {
    }

    //3>Parameterized constructor

    public TransactionRequestDTO(Long accountId, BigDecimal amount, String transactionType) {
        this.accountId = accountId;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    //4>Getter & Setter

    public @NotNull(message = "Please provide the valid account id") Long getAccountId() {
        return accountId;
    }

    public void setAccountId(@NotNull(message = "Please provide the valid account id") Long accountId) {
        this.accountId = accountId;
    }

    public @Min(4) BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(@Min(4) BigDecimal amount) {
        this.amount = amount;
    }

    public @NotEmpty(message = "Please provide the transaction type mode") String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(@NotEmpty(message = "Please provide the transaction type mode") String transactionType) {
        this.transactionType = transactionType;
    }

    //5>toString()

    @Override
    public String toString() {
        return "TransactionRequestDTO{" +
                "accountId=" + accountId +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
