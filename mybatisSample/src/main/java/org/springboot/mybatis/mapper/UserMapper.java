package org.springboot.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springboot.mybatis.entity.UserEntiry;

public interface UserMapper {
	/**
	 * @Select 是查询类的注解，所有的查询均使用这个注解
	 * @Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰  (column="数据库字段名")
	 * @Insert 插入数据库使用，直接传入实体类会自动解析属性到对应的值
	 * @Update 负责修改，也可以直接传入对象
	 * @Delete 负责删除
	 */
	//#和$的区别：
	// This example creates a prepared statement, something like select * from teacher where name = ?;
	//@Select("Select * from teacher where name = #{name}")
	//Teacher selectTeachForGivenName(@Param("name") String name);

	// This example creates n inlined statement, something like select * from teacher where name = 'someName';
	//@Select("Select * from teacher where name = '${name}'")
	//Teacher selectTeachForGivenName(@Param("name") String name);
	
	

	@Select("SELECT * FROM users")
	@Results({
		@Result(property = "userSex",  column = "user_sex"),
	})
	List<UserEntiry> getAll();
	
	@Select("SELECT * FROM users WHERE id=#{id}")
	@Results({
		@Result(property="userSex",column="user_sex"),
	})
	UserEntiry getOne(Long id);
	
	@Insert("INSERT INTO users(id,userName,password,user_sex) VALUES(#{id},#{userName},#{password},#{userSex})")
	void Insert(UserEntiry user);
	
	@Update("UPDATE users SET userName=#{userName} where id=#{id}")
	void update(UserEntiry user);
	
	@Delete("DELETE FROM users WHERE id=#{id}")
	void delete(Long id );
	
	
}
