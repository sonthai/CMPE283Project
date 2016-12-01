package com.dashboard.controller;

import java.util.HashMap;

import com.dashboard.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.domain.ResponseMessage;

@RestController
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserServices userServices;

	@RequestMapping(method = RequestMethod.POST, value="/user/login", consumes = "application/json")
	public ResponseMessage login(@RequestBody HashMap<String, String> data) {
		log.info("Login API is called");
		ResponseMessage response = new ResponseMessage();

		boolean responseCode =  userServices.login(data);

		if(responseCode) {
			response.setErrorCode(0);
		}
		else {
			response.setErrorCode(1);
		}

		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/user/register", consumes = "application/json")
	public ResponseMessage register(@RequestBody HashMap<String, String> data) {
		log.info("Register API is called");
		ResponseMessage response = new ResponseMessage();
		
		int responseCode =  userServices.register(data);

		response.setErrorCode(responseCode);
		
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value="/user/test", produces = "application/json")
	public ResponseMessage testAPI() {
		log.info("User Test API is called");
		ResponseMessage response = new ResponseMessage();

		response.setResponseMsg("Test goes through");
		response.setErrorCode(0);
		response.setData(null);

		return response;
	}




}
