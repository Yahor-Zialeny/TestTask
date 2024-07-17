package com.example.task.Services;

import com.example.task.Models.Company;

import java.util.List;

public interface ICompanyService {
    public Company getCompanyById(long id);
    public List<Company> getAllCompanies();
    public Company updateCompany(Company company);
    public void deleteCompany(long id);
}
