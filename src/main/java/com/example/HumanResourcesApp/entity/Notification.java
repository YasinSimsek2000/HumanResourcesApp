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
@Table(name = "notification")
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String messageTitle;
    private String messageText;
    private String messageFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "manager-notification")
    private Manager manager;

}
