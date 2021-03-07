package com.mashibing.apidriver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.*;
import java.util.function.Predicate;

//@SpringBootTest
class ApiDriverApplicationTests {

    @SneakyThrows
    @Test
    void contextLoads() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("a","a");
    }

}
