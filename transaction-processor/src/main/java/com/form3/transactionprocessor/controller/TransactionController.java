package com.form3.transactionprocessor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.form3.transactionprocessor.model.Transaction;
import com.form3.transactionprocessor.model.TransactionData;
import com.form3.transactionprocessor.model.exception.TransactionAlreadyExistsException;
import com.form3.transactionprocessor.model.exception.TransactionNotFoundException;
import com.form3.transactionprocessor.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;
    private static final ResponseEntity<java.io.Serializable> OK_RESPONSE = new ResponseEntity<>(
            "{\"status\":200,\"message\": \"OK\"}", HttpStatus.OK);

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public TransactionData getAll() {
        return transactionService.readAll();
    }

    @GetMapping("/{id}")
    public Transaction get(@PathVariable String id) {
        return transactionService.read(id)
                .orElseThrow(() -> new TransactionNotFoundException("Could not find transaction with id: " + id, null));
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        transactionService.read(transaction.getId()).ifPresent(oldTransaction -> {
            throw new TransactionAlreadyExistsException(
                    "Transaction with id: " + transaction.getId() + " already exists", null);
        });
        return transactionService.create(transaction);
    }

    @PutMapping("/{id}")
    public Transaction update(@PathVariable String id, @RequestBody Transaction transaction) {
        return transactionService.read(id)
                .map(maybeTransaction -> transactionService.update(transaction))
                .orElseThrow(() -> new TransactionNotFoundException(
                        "Could not find transaction with id: " + transaction.getId(), null));
    }

    @DeleteMapping
    public TransactionData delete() {
        transactionService.deleteAll();
        return transactionService.readAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        return transactionService.read(id).map(transaction -> {
            transactionService.deleteById(id);
            return OK_RESPONSE;
        }).orElseThrow(() -> new TransactionNotFoundException("Could not find transaction with id: " + id, null));
    }
}
