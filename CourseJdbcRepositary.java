package com.minlearnspring.learnjpahibernate.comJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.minlearnspring.learnjpahibernate.course.Course;
@Repository
public class CourseJdbcRepositary {
	@Autowired
  private   JdbcTemplate  springJdbcTemplate;
  
  private static String INSERT_QUERY =
		  """
		  		insert into course (ID, NAME , AUTHOR)
		  		values (?, ?, ?);
		  		""";
  private static String SELECT_QUERY = """
  		 select * from course 
  		 where id =?
  		""";
  
  public void insert(Course course) {
	  springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
  }
  
  public Course findByid(long id) {
	 return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class),id);
  }
  
}
