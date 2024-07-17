package com.example.task.Services;

import com.example.task.Models.Employee;

import java.util.List;

public interface IEmployeeService {
    public Employee getEmployeeById(long id);
    public List<Employee> getAllEmployees();
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(long id);
}
