package com.teamwebsoft.controllers;

import com.teamwebsoft.models.AccountTransactions;
import com.teamwebsoft.repositories.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam long id){
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.findByCustomerIdOrderByTransactionsDtDesc(id);
        if(accountTransactions != null){
            return accountTransactions;
        }
        else{
            return null;
        }
    }

}
