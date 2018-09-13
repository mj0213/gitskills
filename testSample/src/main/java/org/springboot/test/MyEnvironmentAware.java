package org.springboot.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

//凡是被Spring管理的类，实现接口EnvironmentAware重写方法setEnvironment可以在工程启动时，获取到系统环境变量和application配置文件中的变量
public class MyEnvironmentAware implements EnvironmentAware{

	@Value("${myUrl}")
	private String url;
	//注意：重写setEnvironment方法时在系统启动时被执行
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("application.properties"+url);//打印注入的属性信息
		System.out.println(environment.getProperty("JAVA_HOME"));//通过environment获取系统属性
		System.out.println(environment.getProperty("myUrl"));//也可以获取到application.properties中的属性
		//获取到前缀是“spring.datasource.”属性列表值
	}
	
}
