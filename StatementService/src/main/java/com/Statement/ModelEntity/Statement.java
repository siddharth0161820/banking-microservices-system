package com.Statement.ModelEntity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Statement_Inf0")
public class Statement {
    //1>Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long statementId;
    private Long accountId;
    private LocalDate startDate;
    private LocalDate  endDate;
    private BigDecimal balance;

    //2>Default Constructor
    public Statement() {
    }

    //3>Parameterized Constructor

    public Statement(Long statementId, Long accountId, LocalDate startDate, LocalDate endDate, BigDecimal balance) {
        this.statementId = statementId;
        this.accountId = accountId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.balance = balance;
    }

    //4>Getter & Setter

    public Long getStatementId() {
        return statementId;
    }

    public void setStatementId(Long statementId) {
        this.statementId = statementId;
    }

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
        return "Statement{" +
                "statementId=" + statementId +
                ", accountId=" + accountId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", balance=" + balance +
                '}';
    }
}
