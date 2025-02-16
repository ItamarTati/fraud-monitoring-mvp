package com.example.fraudmonitoring.service;

import com.example.fraudmonitoring.model.Transaction;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class FraudDetectionService {
    public boolean isSuspicious(Transaction transaction) {
        return transaction.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0; // Flag if amount > 10K
    }
}