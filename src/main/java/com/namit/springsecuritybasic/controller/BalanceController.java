package com.namit.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/my-balance")
    public String getBalanceDetails(){
        return "returning balance details from db";
    }
}
