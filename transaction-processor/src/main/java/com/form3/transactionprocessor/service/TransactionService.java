package com.form3.transactionprocessor.service;

import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.form3.transactionprocessor.model.Transaction;
import com.form3.transactionprocessor.model.TransactionData;

@Service
public interface TransactionService {

    @NonNull Transaction create(@NonNull Transaction transaction);

    @NonNull TransactionData readAll();

    @NonNull Optional<Transaction> read(@NonNull String id);

    @NonNull Transaction update(@NonNull Transaction transaction);

    void deleteAll();

    void deleteById(@NonNull String id);

}
