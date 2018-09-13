package org.springboot.mybatis.schedul;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
	//@Scheduled 参数可以接受两种定时的设置，一种是常用的cron="*/6****?";一种是 fixedRate =6000，两种都表示每个六秒执行
	//@Scheduled(fixeRate =6000) :上一次开始执行时间点之后6秒在执行
	//@Scheduled(fixedDelay=6000):上一次执行完毕时间点之后6秒在执行
	//@Scheduled(initialDeley=1000,fixedRate=6000):第一次延迟一秒后执行，之后按fixedRate的规则每6秒执行一次
	
	
	private int count=0;
	@Scheduled(cron = "0/6 * * * * ? ")   //6秒
	private void process() {
		System.out.println("this is scheduler task running"+(count++));
		
	}
}
