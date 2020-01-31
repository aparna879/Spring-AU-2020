package com.springau.kafka.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
	
	@KafkaListener(topics = "topic2", groupId = "gId")
	public void consume(String Messg) {
		System.out.println("Consuming at Reciever: "+Messg);
	}
}