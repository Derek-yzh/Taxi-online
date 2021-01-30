package com.mashibing.lnctm;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTransactionManagerServer
public class LncTmApplication {

    public static void main(String[] args) {
        SpringApplication.run(LncTmApplication.class, args);
    }

}
