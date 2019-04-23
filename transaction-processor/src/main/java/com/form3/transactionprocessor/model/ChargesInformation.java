package com.form3.transactionprocessor.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "charges_information")
public class ChargesInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    private String bearerCode;
    @ElementCollection(targetClass = SenderCharge.class, fetch = EAGER)
    @OneToMany(cascade = ALL)
    @JoinColumn(name = "sender_charges_id")
    private List<SenderCharge> senderCharges;
    private String receiverChargesAmount;
    private String receiverChargesCurrency;

    public ChargesInformation() {

    }

    @JsonCreator
    public ChargesInformation(
            @JsonProperty("bearer_code") String bearerCode,
            @JsonProperty("sender_charges") List<SenderCharge> senderCharges,
            @JsonProperty("receiver_charges_amount") String receiverChargesAmount,
            @JsonProperty("receiver_charges_currency") String receiverChargesCurrency) {
        this.bearerCode = bearerCode;
        this.senderCharges = senderCharges;
        this.receiverChargesAmount = receiverChargesAmount;
        this.receiverChargesCurrency = receiverChargesCurrency;
    }

    public String getBearerCode() {
        return bearerCode;
    }

    public List<SenderCharge> getSenderCharges() {
        return senderCharges;
    }

    public String getReceiverChargesAmount() {
        return receiverChargesAmount;
    }

    public String getReceiverChargesCurrency() {
        return receiverChargesCurrency;
    }
}
