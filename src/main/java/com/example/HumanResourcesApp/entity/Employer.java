package com.example.HumanResourcesApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;
import java.util.Date;

@Getter
@Setter
@Entity
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private Date birth_date;
    private Integer age;
    private String mobile;
    private String address; /* must include only city and country by separated " - " */
    private String email;
    private String marital_status;
    private String title;
    private String supervisor;

}
