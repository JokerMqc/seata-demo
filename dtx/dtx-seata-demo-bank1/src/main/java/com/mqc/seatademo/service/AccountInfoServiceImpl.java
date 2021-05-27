package com.mqc.seatademo.service;

import com.mqc.seatademo.dao.AccountDao;
import com.mqc.seatademo.spring.Bank2Client;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AccountInfoServiceImpl implements IAccountInfoService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private Bank2Client bank2Client;

    /**
     * 扣减金额
     * @param accountNo
     * @param amount
     */
    @Override
    @Transactional
    @GlobalTransactional // 开启全局事务
    public void updateAccountBalance(String accountNo, Double amount) {
        log.info("bank1 service begin,XID：{}", RootContext.getXID());
        accountDao.updateAccountBalance(accountNo,amount*-1);

        // 远程调用bank2服务进行增加金额
        String transfer = bank2Client.transfer(amount);
        if("fallback".equals(transfer)){
            //调用李四微服务异常
            throw new RuntimeException("调用李四微服务异常");
        }

        if(amount == 2){
            //人为制造异常,调试使用
            throw new RuntimeException("bank1 make exception..");
        }
    }
}
