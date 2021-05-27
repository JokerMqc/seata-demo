package com.mqc.seatademo.spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="seata-demo-bank2",fallback=Bank2ClientFallback.class)
public interface Bank2Client {
    /**
     * 远程调用李四的微服务
     * @param amount 对应需要扣减的金额
     */
    @GetMapping("/bank2/transfer")
    String transfer(@RequestParam("amount") Double amount);
}
