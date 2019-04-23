package com.form3.transactionprocessor.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.form3.transactionprocessor.model.Transaction;
import com.form3.transactionprocessor.model.TransactionData;
import com.form3.transactionprocessor.repository.TransactionRepository;
import com.form3.transactionprocessor.service.TransactionService;
import com.google.common.collect.Lists;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public @NonNull Transaction create(@NonNull Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public @NonNull TransactionData readAll() {
        return new TransactionData(Lists.newArrayList(transactionRepository.findAll()));
    }

    @Override
    public @NonNull Optional<Transaction> read(@NonNull String id) {
        return transactionRepository.findById(id);
    }

    @Override
    public @NonNull Transaction update(@NonNull Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteAll() {
        transactionRepository.deleteAll();
    }

    @Override
    public void deleteById(@NonNull String id) {
        transactionRepository.deleteById(id);
    }
}
