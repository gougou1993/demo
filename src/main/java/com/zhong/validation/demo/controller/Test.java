package com.zhong.validation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {
	
	@Autowired
	private Environment env;//通过env获得属性
								
	@Value("${test.msg}")//通过@Value注解获得属性
	private String msg;
	@RequestMapping("/test1")
	public String test1(){
		
		return env.getProperty("test.msg");
	}
	@RequestMapping("/test2")
	public String test2(){
		return env.getProperty("test.msg");
	}
	
}
