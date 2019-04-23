package com.form3.transactionprocessor.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionData {

    private final List<Transaction> data;

    @JsonCreator
    public TransactionData(
            @JsonProperty("data") List<Transaction> data) {
        this.data = data;
    }

    public List<Transaction> getData() {
        return data;
    }
}
