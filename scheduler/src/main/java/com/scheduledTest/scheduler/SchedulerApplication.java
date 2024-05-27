package com.scheduledTest.scheduler;

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

		String GET_URL = "https://movieplay-api.onrender.com/api/v1/movies/new?page=0&size=1";

		RestTemplate restTemplate = new RestTemplate();

		String result = restTemplate.getForObject(GET_URL, String.class);

		System.out.println(result);

	}

}
