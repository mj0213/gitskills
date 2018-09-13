package org.springboot.jpa.service;


import java.util.List;
import javax.transaction.Transactional;
import org.springboot.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
	//自定义查询（根据关键字）
	public User findByUserName(String userName);
	public	User findByUserNameOrAge(String userName,Integer age);
		//自定义统计
	public	Long countByAge(Integer age);
		//自定义删除
		@Transactional   //删除需要事物 ,只在当前方法上有效，不会对其他方法生效 （不加注解报错：No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call）
		public	String removeByUserName(String userName);
		public	String deleteByAge(Integer age);
		//自定义模糊查询
		public List<User> findByUserNameLike(String userName);
		//分页
		Page<User> findByAge(Integer age,Pageable pageable);
		//自定义sql查询
		@Modifying
		@Query(value="delete from User where id=?1 and userName=?2")
		public int delByIdAndName(Long id,String userName);
		//多表联查
		//userClass is not mapped  注意：在HQL语句中表名应该是ORM映射的类名，而不是在数据库中的表名。所以解决方法将HQL语句中的userClass改成对应的类名(UserClass)：
		@Query("select c.className,u.userName from UserClass c left join User u on c.userId=u.id where u.id=?1")
		public List getUserClass(Long userId);
}
