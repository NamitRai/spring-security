package com.namit.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("/get-Contacts")
    public String getContactDetails(){
        return "this is contact details";
    }
}
