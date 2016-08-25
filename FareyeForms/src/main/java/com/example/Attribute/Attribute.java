package com.example.Attribute;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by vidur on 16/8/16.
 */
@Entity
public class Attribute {
    @Id
    @GeneratedValue
    int id;
    @NotNull
    String formname;
    @NotNull
    String label;
    @NotNull
    String type;

    public Attribute() {
    }

    public Attribute(String formname, String label, String type) {
        this.formname = formname;
        this.label = label;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getformname() {
        return formname;
    }

    public void setformname(String formname) {
        this.formname = formname;
    }

    public String getlabel() {
        return label;
    }

    public void setlabel(String label) {
        this.label = label;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }
}
