package com.example.quartz.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService {

    public void testService() {
        log.info("【service层定时处理业务逻辑】-----------------------------");
    }
}
