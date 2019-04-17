package com.in28minutes.jpa.hibernate.demo;

import com.in28minutes.jpa.hibernate.demo.entiry.Review;
import com.in28minutes.jpa.hibernate.demo.reposetory.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.reposetory.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Review review = new Review("5", "ok");
		review.setId(4L);
		//		Review review2 = new Review("4", "ok ok");
		List<Review> list = new ArrayList<>();
		list.add(review);
		//		list.add(review2);
		courseRepository.addReviewsForCourse(1L, list);
//		studentRepository.saveStudentWithPassport();
//		repository.playWithEM();
//		Course course = repository.findById(1l);
//		logger.info("Course {}", course);
//		repository.deleteById(1l);
//		repository.save(new Course("course5"));
	}
}
