package com.xzj.lotterysystem;

import lombok.extern.flogger.Flogger;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Target;

@SpringBootTest
public class Logtest {

    private final static Logger logger = LoggerFactory.getLogger(Logtest.class);
    @Test
    void logTest()
    {
        System.out.println("hello");
        logger.info("hello");
    }
}
