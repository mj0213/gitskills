package org.springboot.sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Student> getList(){
		String sql="SELECT ID,NAME,SUMSCORE,AVGSCORE,AGE FROM STUDENT";
		return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int towNum) throws SQLException {
				Student stu = new Student();
				stu.setId(rs.getInt("ID"));
				   stu.setAge(rs.getInt("AGE"));
	                stu.setName(rs.getString("NAME"));
	                stu.setSumScore(rs.getString("SUMSCORE"));
	                stu.setAvgScore(rs.getString("AVGSCORE"));
	                return stu;
			}
		});
		
	}
}
