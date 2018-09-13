package org.springboot.test.controller;

import org.springboot.test.entity.AppConfig;
import org.springboot.test.entity.WiselySettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {
	@Autowired private AppConfig wiselySettings;
	 @RequestMapping(value="/test")
	public  WiselySettings test() {
		 return wiselySettings.testBean();
	}
}
