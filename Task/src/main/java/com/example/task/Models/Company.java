package com.example.task.Models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Table(name = "companies")
@NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String company_name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();
}
