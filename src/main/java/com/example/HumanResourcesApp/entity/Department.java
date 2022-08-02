package com.example.HumanResourcesApp.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter

public class Department {

    @Id
    private Long id;

    private String title;
    private Integer number_of_employee;
    private String head_of_department;
    private Integer head_of_department_id;
}
