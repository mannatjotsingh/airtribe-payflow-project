package com.airtribe.payflow.service;

import com.airtribe.payflow.entity.Transaction;
import com.airtribe.payflow.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    /*
     * Spring automatically creates a TransactionRepository
     * bean and injects it here when the application starts.
     */

    public Transaction sendMoney(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}