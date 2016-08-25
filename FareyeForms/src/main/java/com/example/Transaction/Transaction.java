package com.example.Transaction;

import com.example.RecordValues.AttributeValue;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by vidur on 19/8/16.
 */
@Entity
public class Transaction {
    @Id
    @GeneratedValue
    int id;
    @NotNull
    String formname;
    @NotNull
    String username;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="transactionId")
    Set<AttributeValue> attributeValueSet;

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<AttributeValue> getAttributeValueSet() {
        return attributeValueSet;
    }

    public void setAttributeValueSet(Set<AttributeValue> attributeValueSet) {
        this.attributeValueSet = attributeValueSet;
    }

    public Transaction(String formname, String username, Set<AttributeValue> attributeValueSet) {
        this.formname = formname;
        this.username = username;
        this.attributeValueSet = attributeValueSet;
    }
}
