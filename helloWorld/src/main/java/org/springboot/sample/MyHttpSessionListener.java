package org.springboot.sample;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ServletContext监听器（Listener）文件
 * 监听session的创建与销毁
 *
 */
public class MyHttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		  System.out.println("Session 被创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		  System.out.println("ServletContex初始化");
		
	}

}
