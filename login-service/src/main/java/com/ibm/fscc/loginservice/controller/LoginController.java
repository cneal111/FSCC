package com.ibm.fscc.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ibm.fscc.loginservice.services.impl.LoginServiceImpl;
import com.ibm.fscc.loginservice.shared.LoginDto;

@RestController
@RequestMapping(path="/login")
public class LoginController {


	@Autowired
	private Environment env;
	@Autowired
	private LoginServiceImpl loginService;

	@GetMapping(path="/status/check")
	public String status() {
		return "Working on port " + env.getProperty("server.port");
	}


	@GetMapping(path="/user")
	public LoginDto getUserByEmail(@RequestParam String email){
		return loginService.getLogin(email);	
	}
}
