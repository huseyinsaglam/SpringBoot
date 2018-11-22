package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{

	@Override
	public String createdmessage() {
		
		return "hello spring boot web";
	}
	


}
