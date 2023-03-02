package com.namit.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @GetMapping("/my-cards")
    public String getCardDetails(){
        return "this is card details";
    }
}
