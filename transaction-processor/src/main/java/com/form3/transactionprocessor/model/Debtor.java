package com.form3.transactionprocessor.model;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Debtor {

    @Column(name = "debtor_account_name")
    private String accountName;
    @Column(name = "debtor_account_number")
    private String accountNumber;
    @Column(name = "debtor_account_number_code")
    private String accountNumberCode;
    @Column(name = "debtor_address")
    private String address;
    @Column(name = "debtor_bank_id")
    private String bankId;
    @Column(name = "debtor_bank_id_code")
    private String bankIdCode;
    @Column(name = "debtor_name")
    private String name;

    public Debtor() {

    }

    @JsonCreator
    public Debtor(
            @JsonProperty("account_name") String accountName,
            @JsonProperty("account_number") String accountNumber,
            @JsonProperty("account_number_code") String accountNumberCode,
            @JsonProperty("address") String address,
            @JsonProperty("bank_id") String bankId,
            @JsonProperty("bank_id_code") String bankIdCode,
            @JsonProperty("name") String name) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountNumberCode = accountNumberCode;
        this.address = address;
        this.bankId = bankId;
        this.bankIdCode = bankIdCode;
        this.name = name;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountNumberCode() {
        return accountNumberCode;
    }

    public String getAddress() {
        return address;
    }

    public String getBankId() {
        return bankId;
    }

    public String getBankIdCode() {
        return bankIdCode;
    }

    public String getName() {
        return name;
    }
}
