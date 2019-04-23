package com.form3.transactionprocessor.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import com.form3.transactionprocessor.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, String> {

    @NonNull Optional<Transaction> findById(@NonNull String id);

}
