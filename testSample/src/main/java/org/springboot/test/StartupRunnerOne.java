package org.springboot.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
@Order(value=1)
public class StartupRunnerOne implements CommandLineRunner,EnvironmentAware{
	@Value("${myUrl}")
	private String myUrl;
	//实际应用中，我们会有在项目服务启动的时候就去加载一些数据或做一些事情这样的需求。为了解决这样的问题， 
	//Spring Boot 为我们提供了一个方法，通过实现接口 CommandLineRunner 来实现。
	@Override
	public void run(String... args) throws Exception {
		System.out.println("我要在启动类之前执行     "+myUrl);
	}
	//注意：重写setEnvironment方法时在系统启动时被执行
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("application.properties"+myUrl);//打印注入的属性信息
		System.out.println(environment.getProperty("JAVA_HOME"));//通过environment获取系统属性
		System.out.println(environment.getProperty("myUrl"));//也可以获取到application.properties中的属性
		//获取到前缀是“spring.datasource.”属性列表值
	}

}
