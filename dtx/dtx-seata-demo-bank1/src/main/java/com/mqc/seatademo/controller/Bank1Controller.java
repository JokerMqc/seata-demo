package com.mqc.seatademo.controller;

import com.mqc.seatademo.service.IAccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
public class Bank1Controller {

    @Autowired
    IAccountInfoService accountInfoService;

    //张三转账
    @GetMapping("/transfer")
    public String transfer(@RequestParam("amount") Double amount){
        accountInfoService.updateAccountBalance("1",amount);
        return "bank1"+amount;
    }
}
