package org.springboot.sample;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{

	public void addInterceptors(InterceptorRegistry registry) {
		//多个拦截器组成一个拦截链   addPathPatterens 用于添加拦截规则   excludePathPatterns 用于排除拦截
		registry.addInterceptor(new MyIMyInterceptor1()).addPathPatterns("/**");
		registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
		super.addInterceptors(registry);

	}
}
