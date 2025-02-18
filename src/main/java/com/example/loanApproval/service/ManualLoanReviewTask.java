package com.example.loanApproval.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ManualLoanReviewTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {

        int creditScore = (int) execution.getVariable("creditScore");
        double loanAmount = (double) execution.getVariable("loanAmount");

        String decision;
        log.info("Manual Review Required for Loan Amount > 50K");

        if (creditScore >= 600 && loanAmount <= 100000) {
            decision = "approved";
            log.info("Loan Approved");
        }
        else {
            decision = "rejected";
            log.info("Loan Rejected");
        }

        execution.setVariable("Approval", decision);
        log.info("Loan Approval Decision: {}", decision);

    }
}
