package com.ashok.springbootwebsocket.resource;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.ashok.springbootwebsocket.model.User;
import com.ashok.springbootwebsocket.model.UserResponse;

@Controller
public class UserController {

	//similar to rest endpoint,config the message end point
	@MessageMapping("/user")
	@SendTo("/topic/user")
	public UserResponse getUser(User user) {
		return new UserResponse(user.getName());
	}
}
