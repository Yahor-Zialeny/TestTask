package com.example.task.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
}
