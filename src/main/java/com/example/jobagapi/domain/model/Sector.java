package com.example.jobagapi.domain.model;

import javax.persistence.*;

@Entity
@Table(name ="sectors")
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private String description;



}
