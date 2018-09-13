package org.springboot.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
@RestController  //包含@Controller 和@ResponseBody ,是专门为响应式内容的Controller而设计，可直接响应对象为json,而@Controller只为响应页面使用
@RequestMapping("/hello")
public class HelloController {
	
	
	// 在Java类中创建 logger 实例
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SpringBootSampleApplication.class);
	// 在方法中使用日志输出，如
	
	private String name;
	private int age;
	private String sex;
	public HelloController(String name,int age,String sex) {
		this.name =name;
		this.age=age;
		this.sex=sex;
	}
	public HelloController() {
		//空参构造，用于创建对象使用
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}


	@RequestMapping("/getObj")
	 public HelloController getObj() {
		HelloController helloController = new HelloController();
		helloController.setName("majian");
		helloController.setAge(23);
		helloController.setSex("man");
		 logger.debug("日志输出测试 Debug");
		    logger.trace("日志输出测试 Trace");
		    logger.info("日志输出测试 Info");
		return helloController;
		
	}
	@RequestMapping
	public String hello() {
		return "hello Spring boot ";
		}
	@RequestMapping("/info")   //http://localhost:8802/hello/info?name=majian
	public Map<String, String> getInfo(@RequestParam String name){
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		return map;
	} 
	@RequestMapping("list")
	public List<Map<String, String>> getList(){
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for(int i =1;i<=5;i++) {
			map= new HashMap<>();
			map.put("name", "Shanhy-"+i);
			list.add(map);
		}
		return list;
	}
}
