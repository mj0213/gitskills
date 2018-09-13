package org.springboot.shiro.dao;

import org.hibernate.Session;
import org.springboot.shiro.entity.User;
import org.springframework.stereotype.Repository;
@Repository
public class userDao {
	
public User findByName(String loginName) {
	Session session=HibernateUtil.getSession();
	return session.createQuery("from User a where a.username=:loginName ", User.class).setParameter("username", loginName).getSingleResult();
}
}
