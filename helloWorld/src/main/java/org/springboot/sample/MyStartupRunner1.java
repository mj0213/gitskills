package org.springboot.sample;

import org.springframework.boot.CommandLineRunner;

/**
 * 服务启动执行
 * @author Administrator
 *实际应用中，我们会有在项目服务启动的时候就去加载一些数据或做一些事情这样的需求。 
为了解决这样的问题，Spring Boot 为我们提供了一个方法，通过实现接口 CommandLineRunner 来实现。
 */
public class MyStartupRunner1 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
	}
}
