package com.springau.kafka.controller;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springau.kafka.services.Sender;

@RestController
@RequestMapping(value = "/kafka")
public class MainController {
	private final Sender sender;

	@Autowired
	public MainController(Sender sender) {
		this.sender = sender;
	}

	@PostMapping(value = "/done")
	public void sendMessageToKafkaTopic(@RequestParam("message") String messg) {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				Random random = new Random();
				int number = random.nextInt(10000);
				sender.sendMessg(number+"");
			}
		}, 0, 2000);
	}
}