package org.springboot.jpa.test;


import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.jpa.service.UsreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTest {
@Autowired
private UsreService usreService;
	@Test
	public void getUsreClass() {
		Long userId=(long) 1;
		List list = usreService.getUserClass(userId);
		System.out.println(list);
	}

}
