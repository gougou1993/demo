package com.zhong.validation.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhong.validation.demo.config.MyProps;
import com.zhong.validation.demo.config.MyWebConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AppTest {

	@Autowired
	private MyProps myProps;
	@Autowired
	private MyWebConfig myWebConfig;
	//使用@Value方式（常用）：
	
	@Value("${test.msg}")
	private String msg;
	@Autowired
	private Environment env;
	@Test
	  public void propsTest() throws JsonProcessingException { 
		ObjectMapper objectMapper = new ObjectMapper();
	    System.out.println("simpleProp: " + myProps.getSimpleProp()); 
	    System.out.println("arrayProps: " + objectMapper.writeValueAsString(myProps.getArrayProps())); 
	    System.out.println("listProp1: " + objectMapper.writeValueAsString(myProps.getListProp1())); 
	    System.out.println("listProp2: " + objectMapper.writeValueAsString(myProps.getListProp2())); 
	    System.out.println("mapProps: " + objectMapper.writeValueAsString(myProps.getMapProps())); 
	    
	    //自定义配置文件属性获取
	    System.out.println(myWebConfig.getAuthor());
	    
	    System.out.println("env获得属性"+env.getProperty("test.msg"));
	    System.out.println("使用@Value方式(常用)"+msg);
	
	}
	 	
}
