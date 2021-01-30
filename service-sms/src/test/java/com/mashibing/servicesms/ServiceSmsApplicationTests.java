package com.mashibing.servicesms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

//@SpringBootTest
class ServiceSmsApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(new BigDecimal(2.5));
        System.out.println(new BigDecimal(2.1));
        System.out.println(new BigDecimal("2.1"));
    }

}
