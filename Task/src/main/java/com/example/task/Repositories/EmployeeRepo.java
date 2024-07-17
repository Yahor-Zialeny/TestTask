package com.example.task.Repositories;

import com.example.task.Models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {

}
