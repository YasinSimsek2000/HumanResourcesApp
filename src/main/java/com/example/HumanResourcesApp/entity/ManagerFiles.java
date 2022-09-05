package com.example.HumanResourcesApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class ManagerFiles {

    public ManagerFiles (Manager manager, String fileType, String fileName, String filePath) {
        this.manager = manager;
        this.fileType = fileType;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "managerFiles")
    private Manager manager;
    private String fileType;
    private String fileName;
    private String filePath;
}
