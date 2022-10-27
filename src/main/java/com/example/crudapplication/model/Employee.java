package com.example.crudapplication.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fast_Name")
    private String fastName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "email")
    private String email;


}
