package org.springboot.sample;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 使用@WebListener注解，实现ServletContextListener接口
 * @author Administrator
 *ServletContext监听器（Listener）文件
 */
public class MyServletContextLlistrner implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContxt 初始化");
		System.out.println(sce.getServletContext().getServerInfo());
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContxt 销毁");
	}

}
