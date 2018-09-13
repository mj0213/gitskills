package org.springboot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestSampleApplication {

	//主要测试在启动类之前执行、加载properties文件内容/本地环境变量、读取自定义properties
	public static void main(String[] args) {
		SpringApplication.run(TestSampleApplication.class, args);
	}
}
