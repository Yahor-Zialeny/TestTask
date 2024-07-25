package com.example.task.Controllers;

import com.example.task.StandardResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class HomeController {
    private static final String SUCCESS_STATUS = "success";
    private static final int CODE_SUCCESS = 100;
    @GetMapping
    public StandardResponse home() {
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
}
