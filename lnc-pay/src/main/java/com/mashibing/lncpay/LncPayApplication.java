package com.mashibing.lncpay;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDistributedTransaction
public class LncPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LncPayApplication.class, args);
    }

}
