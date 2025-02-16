package com.example.fraudmonitoring.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    private String date;
    private boolean flagged;

    public boolean isFlagged() {
        return flagged;
    }
    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(boolean flagged) {
        this.amount = amount;
    }
}