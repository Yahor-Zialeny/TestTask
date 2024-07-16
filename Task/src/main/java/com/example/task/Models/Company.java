package com.example.task.Models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "companies")
@NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
public class Company {
    @Id
    private long id;
    private String company_name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();
}
