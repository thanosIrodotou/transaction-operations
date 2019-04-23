package com.form3.transactionprocessor.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@IdClass(PartyId.class)
public class Party {

    private String accountName;
    @Id
    private String accountNumber;
    private String accountNumberCode;
    private Integer accountType;
    private String address;
    @Id
    private String bankId;
    @Id
    private String bankIdCode;
    private String name;

    public Party() {

    }

    @JsonCreator
    public Party(
            @JsonProperty("account_name") String accountName,
            @JsonProperty("account_number") String accountNumber,
            @JsonProperty("account_number_code") String accountNumberCode,
            @JsonProperty("account_type") Integer accountType,
            @JsonProperty("address") String address,
            @JsonProperty("bank_id") String bankId,
            @JsonProperty("bank_id_code") String bankIdCode,
            @JsonProperty("name") String name) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountNumberCode = accountNumberCode;
        this.accountType = accountType;
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

    public Integer getAccountType() {
        return accountType;
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
