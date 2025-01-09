package com.cours.jee.model;

import java.io.Serializable;

// Exemple de Java Bean
public class Message implements Serializable {
    private String value;

    public Message() {
    }

    public Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
