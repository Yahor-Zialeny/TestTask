package com.example.task;

import com.example.task.Models.Company;
import com.example.task.Models.Employee;
import com.example.task.Repositories.CompanyRepo;
import com.example.task.Repositories.EmployeeRepo;
import com.example.task.Services.CompanyService;
import org.springframework.web.bind.annotation.*;
import com.example.task.Services.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {
    private final ICompanyService ICompanyService;
    private final IEmployeeService IEmployeeService;
    private static final String SUCCESS_STATUS = "success";
    private static final int CODE_SUCCESS = 100;


    public RestController(EmployeeRepo employeeRepo, CompanyRepo companyRepo) {
        this.ICompanyService =  new CompanyService(companyRepo, employeeRepo);
        this.IEmployeeService =  new EmployeeService(employeeRepo, companyRepo);
    }

    @GetMapping
    public StandardResponse showStatus() {
        return new StandardResponse(SUCCESS_STATUS, 1);
    }
    @GetMapping("/company")
    public String getCompanyById(Long id) {
        return ICompanyService.getCompanyById(id).toString();
    }
    @DeleteMapping("/company")
    public StandardResponse delete(@RequestParam long companyId){
        ICompanyService.deleteCompany(companyId);
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
    @PostMapping("/company")
    public StandardResponse addCompany(@RequestBody Company company) {
        ICompanyService.updateCompany(company);
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
    @GetMapping("/employee")
    public List<Employee> getEmployeesByCompanyId(@RequestParam long id) {
        return ICompanyService.getCompanyById(id).getEmployees();
    }
    @DeleteMapping("/employee")
    public StandardResponse deleteEmployee(@RequestParam long employeeId){
        IEmployeeService.deleteEmployee(employeeId);
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
    @PostMapping("/employee")
    public StandardResponse addEmployee(@RequestBody Employee employee) {
        IEmployeeService.updateEmployee(employee);
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
}
