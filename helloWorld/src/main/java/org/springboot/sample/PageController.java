package org.springboot.sample;

import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//访问web页面的三种方式


@Controller
public class PageController {
	//从application.properties中读取配置，如取不到默认值为HELLO MAJIAN
	//把读取配置文件中的值赋值给变量
	@Value("${application.inihello:HELLO MAJIAN}")
	private String iHello ;
	private String hello;
	@PostConstruct
	private void init(){
		hello=iHello;
	}
	//private String hello = "Hello Majian";//定义了一个成员变量
	
	//默认页 @RequestMapping("/")  //不是@RequestMapping  如果不写参数，则为全局默认页，加入输入404页面，也会自动访问到这个页面   如果加了"/"，则只会访问到根页面
	
	@RequestMapping(value= {"/","/index"})
	
	public String index(Map<String,Object> model) {
		//直接返回字符串，框架会默认去spring.view.prefix 目录下的（index拼接spring.view.suffix）页面
		//本例为 /WEB-INF/jsp/index.jsp
		model.put("time", new Date());
		model.put("message", hello);
		return "index";
	}
	
	//以下是model 参数化和使用ModelAndView 的区别    最后都是将值返回到页面
	
	//响应到jsp页面page1
	@RequestMapping("/page1")
	public ModelAndView page1() {
		//页面位置  /WEB-INF/jsp/page/page.jsp
		ModelAndView m = new ModelAndView("page/page1");   //注意，不要导错包 ，错误包：import org.springframework.web.portlet.ModelAndView;
		m.addObject("content",hello);
		return m;
	}
	
	//响应到jsp页面的page1(可以直接使用Model分装内容，直接返回页面字符串)
	@RequestMapping("/page2")
	public String page2(Model model) {
		//页面位置  /WEB-INF/jsp/page/page.jsp
		 model.addAttribute("content", hello + "（第二种）");
	        return "page/page1";
	}
	
	
}
