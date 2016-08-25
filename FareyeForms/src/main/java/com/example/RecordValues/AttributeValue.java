package com.example.RecordValues;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by vidur on 16/8/16.
 */
@Entity
public class AttributeValue {
    @Id
    @GeneratedValue
    int id;
    @NotNull
    int attributeId;
    @NotNull
            @Column(name="transactionId")
    int transactionId;
    @NotNull
    String attributevalue;

    public AttributeValue() {
    }

    public AttributeValue(int attributeId, int transactionId, String attributevalue) {
        this.attributeId = attributeId;
        this.transactionId = transactionId;
        this.attributevalue = attributevalue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getAttributevalue() {
        return attributevalue;
    }

    public void setAttributevalue(String attributevalue) {
        this.attributevalue = attributevalue;
    }
}

