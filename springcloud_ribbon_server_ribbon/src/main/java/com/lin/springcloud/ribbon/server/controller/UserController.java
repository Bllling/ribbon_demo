package com.lin.springcloud.ribbon.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 面向服务器调用
	 * @return
	 */
	@GetMapping("/hi")
	public String helloConsumer() {
		return restTemplate.getForEntity("http://user-service/hello", String.class).getBody();
	}
	
	@RequestMapping("/test")
	public String test(){
		return "test end";
	}
}
