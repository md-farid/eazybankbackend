package com.teamwebsoft.controllers;

import com.teamwebsoft.models.Customer;
import com.teamwebsoft.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody Customer customer){
        Customer saveCustomer = null;
        try{
            String hashPassword = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPassword);
            customer.setCreatedAt(new Date(System.currentTimeMillis()));
            saveCustomer = customerRepository.save(customer);
            if(saveCustomer.getId() > 0) {
                return "Customer created successfully.";
            }
        }
        catch (Exception ex){
            return "An exception occurred "+ ex.getMessage();
        }
        return null;
    }

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        List<Customer> customers = customerRepository.findByEmail(authentication.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;
        }
    }
}
