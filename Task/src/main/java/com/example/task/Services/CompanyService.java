package com.example.task.Services;

import com.example.task.Models.Company;
import com.example.task.Models.Employee;
import com.example.task.Repositories.CompanyRepo;
import com.example.task.Repositories.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService implements ICompanyService {
    private CompanyRepo companyRepo;
    private EmployeeRepo employeeRepo;

    public CompanyService(CompanyRepo companyRepo, EmployeeRepo employeeRepo) {
        this.companyRepo = companyRepo;
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Company getCompanyById(long id) {
        Company company = companyRepo.findById(id).get();
        for(Employee employee : company.getEmployees()){
            employee.setCompany(null);
        }
        return company;
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        companyRepo.findAll().forEach(companies::add);
        return companies;
    }

    @Override
    public void deleteCompany(long id) {
        Company company = companyRepo.findById(id).get();
        employeeRepo.deleteAll(company.getEmployees());
        companyRepo.deleteById(id);
    }

    @Override
    public Company updateCompany(Company company) {
        return companyRepo.save(company);
    }
}
