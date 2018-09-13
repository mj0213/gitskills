package org.springboot.shiro.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	//session 是单线程，不安全
	private static ThreadLocal<Session> sessionLocal = new ThreadLocal<>();//线程安全的一个容器，与当前线程相关
	
	static{
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getSession(){
		Session session = sessionLocal.get();
		if(session == null){
			session = sessionFactory.openSession();
			sessionLocal.set(session);//将session绑定到线程安全的容器
		}
		return session;
	}
	
	public static void close(Session session){
		if(session != null){
			session.close();
			sessionLocal.remove();
			sessionLocal.set(null);//清空内容
		}
	}
	
	public static Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public static void queryBySql(){
		//Session session = getCurrentSession();
		//session.createNativeQuery("select * from employee where id=?").setParameter(0, "")
		//离线查询
//		CriteriaQuery<Employee> query =CriteriaQuery
		
		
	}
}
