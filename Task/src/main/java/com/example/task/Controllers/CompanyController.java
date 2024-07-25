package com.example.task.Controllers;

import com.example.task.Models.Company;
import com.example.task.Repositories.CompanyRepo;
import com.example.task.Repositories.EmployeeRepo;
import com.example.task.Services.CompanyService;
import com.example.task.StandardResponse;
import org.springframework.web.bind.annotation.*;
import com.example.task.Services.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/company")
public class CompanyController {
    private final ICompanyService ICompanyService;
    private final IEmployeeService IEmployeeService;
    private static final String SUCCESS_STATUS = "success";
    private static final int CODE_SUCCESS = 100;


    public CompanyController(EmployeeRepo employeeRepo, CompanyRepo companyRepo) {
        this.ICompanyService =  new CompanyService(companyRepo, employeeRepo);
        this.IEmployeeService =  new EmployeeService(employeeRepo, companyRepo);
    }

    @GetMapping
    public Company getCompanyById(Long id) {
        return ICompanyService.getCompanyById(id);
    }
    @DeleteMapping
    public StandardResponse delete(@RequestParam long companyId){
        ICompanyService.deleteCompany(companyId);
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
    @PostMapping
    public StandardResponse addCompany(@RequestBody Company company) {
        ICompanyService.updateCompany(company);
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
    @PutMapping
    public StandardResponse updateCompany(@RequestBody Company company) {
        ICompanyService.updateCompany(company);
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
}
