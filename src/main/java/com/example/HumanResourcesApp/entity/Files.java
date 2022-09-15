package com.example.HumanResourcesApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Files {

    public Files(String fileType, String fileName, String filePath) {
        this.fileType = fileType;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "departmentFiles")
    private Department department;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "employeeFiles")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "managerFiles")
    private Manager manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "projectFiles")
    private Project project;
    private String fileType;
    private String fileName;
    private String filePath;
}
