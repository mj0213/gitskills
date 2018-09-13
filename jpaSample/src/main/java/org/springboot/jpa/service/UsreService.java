package org.springboot.jpa.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springboot.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface UsreService {

	public List<User> getUserList();
	public Optional<User> findUserById(long id);
	public void save(User user);
	public void edit(User user);
	public void delete(long id);
		//自定义查询（根据关键字）
	public	User findByUserName(String userName);
	public	User findByUserNameOrAge(String userName,Integer age);
		//自定义统计
	public Long countByAge(Integer age);
		//自定义删除
		@Transactional   //删除需要事物 ,只在当前方法上有效，不会对其他方法生效,加在最外层，整个service都可以使用 （不加注解报错：No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call）
	public	String removeByUserName(String userName);
	public	String deleteByAge(Integer age);
	//模糊查询
	public List<User> findByUserNameLike(String userName);
	//分页
	Page<User> findByAge(Integer age,Pageable pageable);
	//自定义sql查询
	public int delByIdAndName(Long id,String userName);
	//多表联查
	public List getUserClass(Long userId);
}
