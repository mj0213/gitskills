package org.springboot.test.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

//spring boot 使用自定义application.properties文件

@Configuration
@PropertySource("classpath:/config/my.properties")
public class AppConfig  {
	/**
	 *  @Autowired
     Environment env;

     @Bean
     public TestBean testBean() {
         TestBean testBean = new TestBean();
         testBean.setName(env.getProperty("testbean.name"));
         return testBean;
     }

	 */
	@Autowired Environment env;
	@Bean
	public WiselySettings testBean() {
		WiselySettings wiselySettings =new WiselySettings();
		wiselySettings.setName(env.getProperty("name"));
		wiselySettings.setGender(env.getProperty("gender"));
		return wiselySettings;
		
	}
	
}
