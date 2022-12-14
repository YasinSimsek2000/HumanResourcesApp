package com.example.HumanResourcesApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String department_name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    @JsonManagedReference(value = "department-employees")
    private List<Employee> employee;

    @JsonIgnore
    @ManyToMany(mappedBy = "departments" , fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Project> projects;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    @JsonManagedReference(value = "departmentFiles")
    private List<Files> files;
}
