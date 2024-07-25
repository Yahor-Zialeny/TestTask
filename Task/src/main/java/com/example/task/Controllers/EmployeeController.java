package com.example.task.Controllers;

import com.example.task.Models.Employee;
import com.example.task.Repositories.CompanyRepo;
import com.example.task.Repositories.EmployeeRepo;
import com.example.task.Services.CompanyService;
import com.example.task.Services.EmployeeService;
import com.example.task.Services.ICompanyService;
import com.example.task.Services.IEmployeeService;
import com.example.task.StandardResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final ICompanyService ICompanyService;
    private final IEmployeeService IEmployeeService;
    private static final String SUCCESS_STATUS = "success";
    private static final int CODE_SUCCESS = 100;


    public EmployeeController(EmployeeRepo employeeRepo, CompanyRepo companyRepo) {
        this.ICompanyService =  new CompanyService(companyRepo, employeeRepo);
        this.IEmployeeService =  new EmployeeService(employeeRepo, companyRepo);
    }
    @GetMapping
    public List<Employee> getEmployeesByCompanyId() {
        return IEmployeeService.getAllEmployees();
    }
    @DeleteMapping
    public StandardResponse deleteEmployee(@RequestParam long employeeId){
        IEmployeeService.deleteEmployee(employeeId);
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
    @PostMapping
    public StandardResponse addEmployee(@RequestBody Employee employee) {
        IEmployeeService.updateEmployee(employee);
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
    @PutMapping
    public StandardResponse updateEmployee(@RequestBody Employee employee) {
        IEmployeeService.updateEmployee(employee);
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
}
