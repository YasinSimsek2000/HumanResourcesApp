package com.example.HumanResourcesApp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "project")
public class Project {

    @Id
    private Long id;
    private String project_name;

    @OneToOne
    private Employee head_of_project;

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Employee> employees;


    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Department> departments;
}
