package com.mqc.seatademo.service;

public interface IAccountInfoService {
    /**
     * 扣减金额
     * @param accountNo
     * @param amount
     */
    void updateAccountBalance(String accountNo, Double amount);
}
