package com.accenture.kubernetesdemo.queueapp.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.kubernetesdemo.queueapp.QueueConfiguration;

@Controller
public class MessageProducer {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@RequestMapping(value = "/message/create")
	@ResponseBody
	public String sendMessage(String content) {
		rabbitTemplate.convertAndSend(QueueConfiguration.topicExchangeName, "foo.bar.strucken", "Strucken");
		return "Message sent";
	}
}
