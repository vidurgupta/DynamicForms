package com.example.Form;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by vidur on 16/8/16.
 */
@Entity
public class Forms {
    @Id
    String name;


    public Forms() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Forms(String name) {
        this.name = name;
    }
}
