package com.namit.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("/my-loans")
    public String getLoans(){
        return "Here are the loans details from db";
    }
}
