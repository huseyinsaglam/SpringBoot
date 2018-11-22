package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.HelloService;

@Controller
public class Notes1 {
	
	@Autowired
	private HelloService service;
	
	@RequestMapping("/hsaglam")
	public String message(ModelMap map)
	{
		String ad = service.createdmessage();
		map.addAttribute("myad", ad);
		return "page1";
	}

}
