package org.springboot.jpa.test;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.jpa.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

	 @Autowired
	    private StringRedisTemplate stringRedisTemplate;
	    
		@Autowired
		private RedisTemplate redisTemplate;

		@Test
	    public void test() throws Exception {
	        stringRedisTemplate.opsForValue().set("aaa", "111");
	        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	    }
	    
	    @Test
	    public void testObj() throws Exception {
	        Users user=new Users("aa", "aa123456","aa@126.com", "aa","123");
	        ValueOperations<String, Users> operations=redisTemplate.opsForValue();
	        operations.set("com.neox", user);
	        operations.set("com.neo.f", user,1,TimeUnit.SECONDS);
	        Thread.sleep(1000);
	        //redisTemplate.delete("com.neo.f");
	        boolean exists=redisTemplate.hasKey("com.neo.f");
	        if(exists){
	        	System.out.println("exists is true");
	        }else{
	        	System.out.println("exists is false");
	        }
	       // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
	    }
}
