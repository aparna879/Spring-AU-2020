package com.springau.kafka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
	private static final String topic = "topic1";
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessg(String messg) {
		System.out.println(String.format("Produced at Sender: "+ messg));
		this.kafkaTemplate.send(topic, messg);
	}
}