package com.airtribe.payflow.controller;

import com.airtribe.payflow.entity.Transaction;
import com.airtribe.payflow.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction sendMoney(
            @RequestBody Transaction transaction) {

        transaction.setTransactionTime(
                LocalDateTime.now()
        );

        return transactionService.sendMoney(transaction);
    }
}