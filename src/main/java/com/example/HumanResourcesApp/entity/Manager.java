package com.example.HumanResourcesApp.entity;

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
@Table(name = "manager")
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String password;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.REMOVE)
    @JsonManagedReference(value = "managerFiles")
    private List<Files> files;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.REMOVE)
    @JsonManagedReference(value = "manager-notification")
    private List<Notification> notification;
}
