package org.springboot.mybatis;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("org.springboot.mybatis.mapper")  //扫描mapper
@EnableTransactionManagement //事物
//在启动类中添加对mapper包扫描@MapperScan(或者直接在Mapper类上面添加注解@Mapper,建议添加注解在启动类上，不然每个mapper加注解很麻烦)
@EnableScheduling
public class JpaSample1Application {

	public static void main(String[] args) {
		SpringApplication.run(JpaSample1Application.class, args);
	}
}
