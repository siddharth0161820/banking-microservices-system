package com.common.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class StatementRequestDTO {
    //1>Attributes
    private Long accountId;
      @NotNull(message = "Start date should not be empty")
    private LocalDate startDate;
      @NotNull(message = "End  date should not be empty")
    private LocalDate  endDate;
    @DecimalMin(value = "4.00")
    private BigDecimal balance;

    //2>Default Constructor

    public StatementRequestDTO() {
    }
    //3>Parameterized Constructor

    public StatementRequestDTO(Long accountId, LocalDate startDate, LocalDate endDate, BigDecimal balance) {
        this.accountId = accountId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.balance = balance;
    }

    //4>Getter & Setter

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
        return "StatementRequestDTO{" +
                "accountId=" + accountId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", balance=" + balance +
                '}';
    }
}
