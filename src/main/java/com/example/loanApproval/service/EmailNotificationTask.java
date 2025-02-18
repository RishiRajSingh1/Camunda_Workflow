package com.example.loanApproval.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailNotificationTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        String applicantName = (String) execution.getVariable("applicantName");
        execution.setVariable("loanApproved",true);
        boolean loanApproved= (boolean) execution.getVariable("loanApproved");

        String message = loanApproved ?
                "Congratulations " + applicantName + "! Your loan has been approved." :
                "Sorry " + applicantName + ", your loan application was rejected.";

        log.info("Sending email: {}", message);
    }
}
