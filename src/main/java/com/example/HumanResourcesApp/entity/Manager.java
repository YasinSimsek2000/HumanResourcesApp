package com.example.HumanResourcesApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "manager")
public class Manager {

    @Id
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String password;
}
