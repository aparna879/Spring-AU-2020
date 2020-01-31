package com.springau.kafka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Mediater {
		
	private String Messg;
	private static final String topic = "topic2";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessg() {
		System.out.println(String.format("Processor: "+ this.Messg));
		this.kafkaTemplate.send(topic, this.Messg);
	}
	
	@KafkaListener(topics = "topic1", groupId = "gId")
	public void consumeProcessor(String Messg) {
		int num = Integer.parseInt(Messg);
		if(num % 2 != 0) {
			int len = String.valueOf(Messg).length();
			this.Messg = len+"is length of odd number"+num ;
		} else {
			this.Messg = num+"is even";
		}
		this.sendMessg();
	}
}