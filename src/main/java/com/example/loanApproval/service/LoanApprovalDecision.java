package com.example.loanApproval.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("loanApprovalService") // This allows it to be used in BPMN with delegateExpression
public class LoanApprovalDecision implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        int creditScore = (int) execution.getVariable("creditScore");
        double loanAmount = (double) execution.getVariable("loanAmount");

        String decision;

        // Business logic to determine loan approval
        if (creditScore >= 700 && loanAmount <= 50000) {
            decision = "eligible";
        } else if (creditScore < 400) {
            decision = "not eligible";
        } else {
            decision = "not eligible";
        }

        execution.setVariable("isEligible", decision);
        log.info("Loan Eligibility : {}", decision);
    }
}
