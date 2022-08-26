package com.example.news.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SchedulerService {

    private static final Logger log = LoggerFactory.getLogger(NewsServicesImpl.class);

    @Scheduled(initialDelayString = "3000", fixedDelayString = "3000")
    public void doUpdate() throws InterruptedException{
        log.info("Process has been started");
        TimeUnit.HOURS.sleep(20);
        log.info("end process");
    }
}
