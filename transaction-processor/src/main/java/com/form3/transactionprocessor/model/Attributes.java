package com.form3.transactionprocessor.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Attributes {

    private String amount;
    @Embedded
    @ManyToOne(cascade = { PERSIST, MERGE, REFRESH, DETACH })
    private Party beneficiary;
    @Embedded
    @OneToOne(cascade = ALL)
    @JoinColumn(name = "charges_information_id")
    private ChargesInformation chargesInformation;
    private String currency;
    @Embedded
    @ManyToOne(cascade = { PERSIST, MERGE, REFRESH, DETACH })
    private Party debtor;
    private String endToEndReference;
    @Embedded
    private Fx fx;
    private String numercicReference;
    private String paymentId;
    private String paymentPurpose;
    private String paymentScheme;
    private String paymentType;
    private String processingDate;
    private String reference;
    private String schemePaymentSubType;
    private String schemePaymentType;
    @Embedded
    @ManyToOne(cascade = { PERSIST, MERGE, REFRESH, DETACH })
    private Party sponsor;

    public Attributes() {

    }

    @JsonCreator
    public Attributes(
            @JsonProperty("amount") String amount,
            @JsonProperty("beneficiary_party") Party beneficiary,
            @JsonProperty("charges_information") ChargesInformation chargesInformation,
            @JsonProperty("currency") String currency,
            @JsonProperty("debtor_party") Party debtor,
            @JsonProperty("end_to_end_reference") String endToEndReference,
            @JsonProperty("fx") Fx fx,
            @JsonProperty("numeric_reference") String numercicReference,
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("payment_purpose") String paymentPurpose,
            @JsonProperty("payment_scheme") String paymentScheme,
            @JsonProperty("payment_type") String paymentType,
            @JsonProperty("processing_date") String processingDate,
            @JsonProperty("reference") String reference,
            @JsonProperty("scheme_payment_sub_type") String schemePaymentSubType,
            @JsonProperty("scheme_payment_type") String schemePaymentType,
            @JsonProperty("sponsor_party") Party sponsor) {
        this.amount = amount;
        this.beneficiary = beneficiary;
        this.chargesInformation = chargesInformation;
        this.currency = currency;
        this.debtor = debtor;
        this.endToEndReference = endToEndReference;
        this.fx = fx;
        this.numercicReference = numercicReference;
        this.paymentId = paymentId;
        this.paymentPurpose = paymentPurpose;
        this.paymentScheme = paymentScheme;
        this.paymentType = paymentType;
        this.processingDate = processingDate;
        this.reference = reference;
        this.schemePaymentSubType = schemePaymentSubType;
        this.schemePaymentType = schemePaymentType;
        this.sponsor = sponsor;
    }

    public String getAmount() {
        return amount;
    }

    public Party getBeneficiary() {
        return beneficiary;
    }

    public ChargesInformation getChargesInformation() {
        return chargesInformation;
    }

    public String getCurrency() {
        return currency;
    }

    public Party getDebtor() {
        return debtor;
    }

    public String getEndToEndReference() {
        return endToEndReference;
    }

    public Fx getFx() {
        return fx;
    }

    public String getNumercicReference() {
        return numercicReference;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getProcessingDate() {
        return processingDate;
    }

    public String getReference() {
        return reference;
    }

    public String getSchemePaymentSubType() {
        return schemePaymentSubType;
    }

    public String getSchemePaymentType() {
        return schemePaymentType;
    }

    public Party getSponsor() {
        return sponsor;
    }
}
