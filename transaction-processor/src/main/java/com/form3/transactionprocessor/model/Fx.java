package com.form3.transactionprocessor.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fx {

    private String contractReference;
    private String exchangeRate;
    private String originalAmount;
    private String originalCurrency;

    public Fx() {

    }

    @JsonCreator
    public Fx(
            @JsonProperty("contract_reference") String contractReference,
            @JsonProperty("exchange_rate") String exchangeRate,
            @JsonProperty("original_amount") String originalAmount,
            @JsonProperty("original_currency") String originalCurrency) {
        this.contractReference = contractReference;
        this.exchangeRate = exchangeRate;
        this.originalAmount = originalAmount;
        this.originalCurrency = originalCurrency;
    }

    public String getContractReference() {
        return contractReference;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public String getOriginalAmount() {
        return originalAmount;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }
}
