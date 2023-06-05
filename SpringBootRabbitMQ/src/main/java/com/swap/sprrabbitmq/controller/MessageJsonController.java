package com.swap.sprrabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swap.sprrabbitmq.dto.User;
import com.swap.sprrabbitmq.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("/rabbitmqjson")
public class MessageJsonController {

	private RabbitMQJsonProducer jsonProducer;

	//constructor based dependency injection
	//@Autowired, when spring bean has single parameterized constructor then we can ignore it
	public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
		super();
		this.jsonProducer = jsonProducer;
	}
	
	// http://localhost:8080/rabbitmqjson/publish
	@PostMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestBody User user){
		jsonProducer.sendJsonMessage(user);
		return ResponseEntity.ok("Json message sent to RabbitMQ...");
	}


}
