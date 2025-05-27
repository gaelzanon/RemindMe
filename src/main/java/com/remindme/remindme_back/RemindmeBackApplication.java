package com.remindme.remindme_back;

import com.remindme.remindme_back.service.ReminderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;


@SpringBootApplication
public class RemindmeBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemindmeBackApplication.class, args);
	}

}
