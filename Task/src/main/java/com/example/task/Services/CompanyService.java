package com.example.task.Services;

import com.example.task.Models.Company;
import com.example.task.Repositories.CompanyRepo;

import java.util.ArrayList;
import java.util.List;

public class CompanyService implements ICompanyService {
    private CompanyRepo companyRepo;

    @Override
    public Company getCompanyById(long id) {
        return null;
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        companyRepo.findAll().forEach(companies::add);
        return companies;
    }

    @Override
    public void deleteCompany(long id) {
        companyRepo.deleteById(id);
    }

    @Override
    public Company updateCompany(Company company) {
        return companyRepo.save(company);
    }
}
