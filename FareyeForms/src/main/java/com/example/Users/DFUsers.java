package com.example.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by vidur on 16/8/16.
 */
@Entity
public class DFUsers {
    @Id
    String username;
    @NotNull
    String password;
    @NotNull
    String type;

    public DFUsers(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public DFUsers() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
