package com.mashibing.serviceverificationcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

//@SpringBootTest
class ServiceVerificationCodeApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(Math.random());
    }

    @Test
    void testFailCode(){
        String code = null;

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_0000; i++) {
            code = (Math.random()+"").substring(2,8);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        code = null;
        for (int i = 0; i < 100_0000; i++) {
            code = String.valueOf((int)( (Math.random()*9+1)*Math.pow(10,5)));
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }

}
