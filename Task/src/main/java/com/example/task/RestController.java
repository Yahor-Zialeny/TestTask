package com.example.task;

import com.example.task.Repositories.CompanyRepo;
import com.example.task.Repositories.EmployeeRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {
    private CompanyRepo CompanyRepo;
    private EmployeeRepo EmployeeRepo;
    private final String sharedKey = "SHARED_KEY";
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    public StandardResponse showStatus() {
        return new StandardResponse(SUCCESS_STATUS, 1);
    }

}
