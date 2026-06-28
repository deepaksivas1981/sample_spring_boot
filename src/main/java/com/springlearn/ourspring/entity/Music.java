package com.springlearn.ourspring.entity;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;

@Entity
@Table(name="music")
@Data
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name="release_date")
    private String releaseDate;
}
