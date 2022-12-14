package com.example.HumanResourcesApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

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
    private Integer salary;
    private String surname;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "department-employees")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "project-employees")
    private Project project;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    @JsonManagedReference(value = "employeeFiles")
    private List<Files> files;

    public String getEmail() {
        return email;
    }

}
