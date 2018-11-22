package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Notes {
	
	@RequestMapping("/notes1")
	@ResponseBody
	public String message()
	{
		return "hello spring boot";
	}

}
