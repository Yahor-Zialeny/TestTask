package com.example.task.Services;

import com.example.task.Models.Employee;
import com.example.task.Repositories.EmployeeRepo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService{
    private EmployeeRepo employeeRepo;

    public EmployeeService() {
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepo.findAll().forEach(employees::add);
        return employees;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepo.deleteById(id);
    }
}
