package com.example.HumanResourcesApp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "department")
public class Department {

    @Id
    private Long id;
    private String department_name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Employee> employee;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Project> projects;

}
