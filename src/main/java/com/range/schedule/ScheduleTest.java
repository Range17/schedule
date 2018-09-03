package com.range.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//控制台有输出了
@Component
@EnableAsync
public class ScheduleTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Async
//    每间隔10秒输出时间，为liunx时间戳
    @Scheduled(fixedRate = 10000)
    public void LogTime(){
        logger.info("定时任务fixeddDelay"+System.currentTimeMillis()+"距离上次执行任务10秒");
    }


    @Scheduled(fixedDelay = 5000)
    public void LogTime1(){
        logger.info("定时任务fixedRate"+System.currentTimeMillis()+"隔上次执行任务5秒");
    }
//
//    @Scheduled(initialDelay = 3000)
//    public void LogTime2(){
//        logger.info("定时任务intitaDelay"+System.currentTimeMillis());
//    }

    @Scheduled(cron = "0 48 13 ? * 1")
    public void task(){
        logger.info("听说今天是周日");//确实1是周1
    }
}

