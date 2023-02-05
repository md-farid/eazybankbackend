package com.teamwebsoft.controllers;

import com.teamwebsoft.models.Accounts;
import com.teamwebsoft.repositories.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;

    public Accounts getAccountDetails(@RequestParam long id){
        Accounts accounts = accountsRepository.findByCustomerId(id);
        if(accounts != null){
            return accounts;
        }
        else{
            return null;
        }
    }

}
