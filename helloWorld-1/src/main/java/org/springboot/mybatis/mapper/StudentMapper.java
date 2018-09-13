package org.springboot.mybatis.mapper;

import java.util.List;

import org.springboot.mybatis.entity.Student;

public interface StudentMapper {
 
	 List<Student> likeName(String name);
	 Student getById(int id);
	 String getNameById(int id);
}
