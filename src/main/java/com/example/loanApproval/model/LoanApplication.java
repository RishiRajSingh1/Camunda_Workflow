package com.example.loanApproval.model;

import lombok.Data;

@Data
public class LoanApplication {
    private String applicantName;
    private int creditScore;
    private double loanAmount;
    private Boolean loanApproved=false;
}
