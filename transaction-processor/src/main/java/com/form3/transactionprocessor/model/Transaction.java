package com.form3.transactionprocessor.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "transactions")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    private String type;
    @Id
    private String id;
    private int version;
    private String organisationId;
    @Embedded
    private Attributes attributes;

    public Transaction() {
    }

    @JsonCreator
    public Transaction(
            @JsonProperty("type") String type,
            @JsonProperty("id") String id,
            @JsonProperty("version") int version,
            @JsonProperty("organisation_id") String organisationId,
            @JsonProperty("attributes") Attributes attributes) {
        this.type = type;
        this.id = id;
        this.version = version;
        this.organisationId = organisationId;
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getOrganisationId() {
        return organisationId;
    }

    public Attributes getAttributes() {
        return attributes;
    }
}
