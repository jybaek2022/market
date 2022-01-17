package gu.market.batch;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import gu.market.service.MailService;

@Configuration
@EnableScheduling
public class ScheduleTasks
{
    @Scheduled(fixedDelay = 5000)
    //@Scheduled(fixedRate = 5000)  //Or use this
    public void scheduleTasksMethod()
    {
//        System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
    }
    		      // 초 분 시 일 월 요일 년도
    @Scheduled(cron="0 30 13 * * *") 
    public void couponScheduler() throws IOException{
    	//메일테스트 부분

		//
    }
}