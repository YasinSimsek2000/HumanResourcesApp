package com.example.HumanResourcesApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "project")
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    private Long id;
    private String project_name;

    @OneToOne
    private Employee head_of_project;

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Employee> employees;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "projects_departments",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<Department> departments;
}
