package com.ashok.springbootwebsocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.ashok.springbootwebsocket.model.UserResponse;

/**
 * This class is to send messages after a particular duration
 * @author Ashok Sen Gurudayal
 *
 */
@EnableScheduling
@Configuration
public class SchedulerConfig {

	@Autowired
	SimpMessagingTemplate template;
	
	@Scheduled(fixedDelay = 3000) //To send every 3s
	public void sendAdhocMessages() {
		template.convertAndSend("/topic/user", new UserResponse("Fixed Delay scheduler"));
	}
}
