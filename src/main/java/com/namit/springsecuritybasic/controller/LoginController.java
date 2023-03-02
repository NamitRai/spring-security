package com.namit.springsecuritybasic.controller;

import com.namit.springsecuritybasic.entity.Customer;
import com.namit.springsecuritybasic.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    CustomerRepo customerRepo;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer savedCustomer = null;
        ResponseEntity response = null;
        try{
            savedCustomer = customerRepo.save(customer);
            if(savedCustomer.getId()>0){
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given customer details are successfully registered.");
            }
        }
        catch(Exception e){
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An Exception occured while saveing "+e.getMessage());

        }
        return response;
    }
}
