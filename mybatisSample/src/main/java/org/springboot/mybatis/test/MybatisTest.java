package org.springboot.mybatis.test;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.mybatis.entity.UserEntiry;
import org.springboot.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

	@Autowired UserMapper userMapper;
	@Test
	public void testQuery() throws Exception {
		List<UserEntiry> users = userMapper.getAll();
		System.out.println(users.toString());
	}
	
	@Test
	public void getOne() {
		Long id =(long) 2;
		UserEntiry entiry = userMapper.getOne(id);
		System.out.println(entiry.toString());
	}
	
	@Test
	public void insertUser() {
		UserEntiry user = new UserEntiry();
		user.setId((long) 2);
		user.setPassword("333");
		user.setUserName("limeng");
		user.setUserSex("women");
		userMapper.Insert(user);
	}
	@Test
	public void deleteUser() {
		Long id =(long) 2;
		userMapper.delete(id);
	}
	@Test
	@Transactional
	public void updateUser() {
		Long id =(long) 2;
		UserEntiry user = userMapper.getOne(id);
		System.out.println(user.toString());
		user.setUserSex("man");
		userMapper.update(user);
	}
}
