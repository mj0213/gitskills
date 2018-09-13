package org.springboot.sample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//服务启动执行中要加载的数据的先后顺序是可以控制的（注解）
@Component
@Order(value =1)    //@Order 注解的执行优先级是按value值从小到大顺序
public class MyStartupRunner2 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("我先加载。。。。。。。。。");
		
	}

}
