package com.example.loanApproval.controller;

import com.example.loanApproval.model.LoanApplication;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final RuntimeService runtimeService;

    public LoanController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping("/apply")
    public String applyLoan(@RequestBody LoanApplication loanApplication) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("applicantName", loanApplication.getApplicantName());
        variables.put("creditScore", loanApplication.getCreditScore());
        variables.put("loanAmount", loanApplication.getLoanAmount());

        runtimeService.startProcessInstanceByKey("loan-approval", variables);
        return "Loan Application Submitted!";
    }
}
