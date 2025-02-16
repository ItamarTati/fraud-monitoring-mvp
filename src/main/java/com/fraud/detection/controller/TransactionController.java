package com.example.fraudmonitoring.controller;

import com.example.fraudmonitoring.model.Transaction;
import com.example.fraudmonitoring.repository.TransactionRepository;
import com.example.fraudmonitoring.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private FraudDetectionService fraudDetectionService;

    @GetMapping("/")
    public String home() {
        return "index";  // This will return the index.html page
    }

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadTransaction(@RequestBody Transaction transaction) {
        if (fraudDetectionService.isSuspicious(transaction)) {
            transaction.setFlagged(true);
        }
        transactionRepository.save(transaction);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/flagged")
    public List<Transaction> getFlaggedTransactions() {
        return transactionRepository.findByFlaggedTrue();
    }
}