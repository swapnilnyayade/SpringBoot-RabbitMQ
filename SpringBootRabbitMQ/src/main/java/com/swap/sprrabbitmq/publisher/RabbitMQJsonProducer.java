package com.swap.sprrabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.swap.sprrabbitmq.dto.User;

@Service
public class RabbitMQJsonProducer {

	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.json.key}")
	private String routingJsonKey;
	
	private RabbitTemplate rabbitTemplate;
	
	private Logger logger = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

	public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendJsonMessage(User user) {
		logger.info(String.format("Json message sent -> %s", user.toString()));
		rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
	}
	
}

