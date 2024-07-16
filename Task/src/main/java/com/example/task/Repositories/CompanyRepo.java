package com.example.task.Repositories;

import com.example.task.Models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepo extends CrudRepository<Company, Long> { }
