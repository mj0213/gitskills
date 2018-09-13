package org.springboot.mybatis;

import java.util.List;

import org.springboot.mybatis.entity.Student;
import org.springboot.mybatis.mapper.StudentMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybatis")
public class TestController {
private StudentMapper stuMapper;
@RequestMapping("/liekName")
public List<Student> likeName(@RequestParam String name){
	return stuMapper.likeName(name);
}
}
