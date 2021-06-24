package com.ilyakor.lab2.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name="client")
public class Client {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="login", nullable = false)
    private Long username;
    
}
