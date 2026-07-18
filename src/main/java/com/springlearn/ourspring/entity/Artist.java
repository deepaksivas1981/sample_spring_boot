package com.springlearn.ourspring.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class Artist {

    private String name;
    private int noHits;

    public Artist(String theName, int theNoHits) {
        this.name = theName;
        this.noHits = theNoHits;
    }
}
