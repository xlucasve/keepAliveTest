package com.scheduledTest.scheduler;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerApplication.class, args);
	}
	@Scheduled(fixedDelay = 1000*60)
	public void scheduleFixedDelayTask() {
		try {

			Unirest.setTimeouts(0, 0);
			HttpResponse<String> response = Unirest.get("https://movieplay-api.onrender.com/api/v1/keep/")
					.asString();

			System.out.println("is working? " + response.getBody());


		} catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println("Error calling");
		}
	}

}
