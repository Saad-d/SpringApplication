package com.minlearnspring.learnjpahibernate.comJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.minlearnspring.learnjpahibernate.course.Course;

@Component
public class courseCamandJdbc implements CommandLineRunner {
    @Autowired
	private CourseJdbcRepositary repositry ;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repositry.insert (new Course (2, "aws","sohail"));
		repositry.insert (new Course (3, "aws","ahaz"));
		repositry.insert (new Course (4, "avs","saad"));
		repositry.insert (new Course (5, "full stack","altamash"));
		
		System.out.print(repositry.findByid(2));
		System.out.print(repositry.findByid(3));
		
	}

}
