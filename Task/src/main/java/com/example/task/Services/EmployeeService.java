package com.example.task.Services;

import com.example.task.Models.Company;
import com.example.task.Models.Employee;
import com.example.task.Repositories.CompanyRepo;
import com.example.task.Repositories.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    private EmployeeRepo employeeRepo;
    private CompanyRepo companyRepo;
    public EmployeeService(EmployeeRepo employeeRepo, CompanyRepo companyRepo) {
        this.employeeRepo = employeeRepo;
        this.companyRepo = companyRepo;
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
    public void updateEmployee(Employee employee) {
        Company company = companyRepo.findById(employee.getCompany().getId()).get();
        List<Employee> employees = company.getEmployees();
        if (!employees.contains(employee)) {
            employees.add(employee);
            company.setEmployees(employees);
            companyRepo.save(company);
        }
    }



    @Override
    public void deleteEmployee(long id) {
        Employee employee = employeeRepo.findById(id).get();
        Company company = employee.getCompany();
        company.getEmployees().remove(employee);
        employeeRepo.deleteById(id);
    }
}
