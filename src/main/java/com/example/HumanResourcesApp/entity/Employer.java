package com.example.HumanResourcesApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Getter
@Setter
@Entity
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address; /* must include only city and country by separated " - " */
    public Integer age;
    private Date birth_date;
    private String email;
    private String marital_status;
    private String mobile;
    private String name;
    private String supervisor;
    private String surname;
    private String title;

}
