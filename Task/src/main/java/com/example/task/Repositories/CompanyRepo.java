package com.example.task.Repositories;

import com.example.task.Models.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CompanyRepo extends CrudRepository<Company, Long> {
}
