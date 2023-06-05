package com.swap.sprrabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.swap.sprrabbitmq.dto.User;

@Service
public class RabbitMQJsonConsumer {
	private Logger logger = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
	
	@RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
	public void consumeJsonMessage(User user) {
		logger.info(String.format("Received JSON message -> %s", user.toString()));
	}
}
