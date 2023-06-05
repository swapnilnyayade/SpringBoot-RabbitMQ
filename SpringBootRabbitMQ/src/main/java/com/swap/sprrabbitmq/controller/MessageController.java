package com.swap.sprrabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swap.sprrabbitmq.publisher.RabbitMQProducer;

@RestController
@RequestMapping("/rabbitmq")
public class MessageController {

	private RabbitMQProducer producer;

	//constructor based dependency injection
	//@Autowired, when spring bean has single parameterized constructor then we can ignore it
	public MessageController(RabbitMQProducer producer) {
		super();
		this.producer = producer;
	}
	
	// http://localhost:8080/rabbitmq/publish?message=Hello World
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
		producer.sendMessage(message);
		return ResponseEntity.ok("Message sent to RabbitMQ...");
	}
}
