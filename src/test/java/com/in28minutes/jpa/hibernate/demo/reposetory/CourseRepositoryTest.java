package com.in28minutes.jpa.hibernate.demo.reposetory;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	public void findById_basic() {
		
		Course course = repository.findById(1l);
		assertEquals("course1", course.getName());
		logger.info("findById_basic test is Running");
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		
		boolean present = repository.deleteById(1l);
		assertTrue(present);
		present = repository.deleteById(1l);
		assertFalse(present);
		
		Course course = repository.findById(1l);
		assertNull(course);
		logger.info("deleteById_basic test is Running");
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {
		
		Course course = repository.findById(1L);
		assertEquals("course1", course.getName());
		
		course.setName("course1+");
		repository.save(course);
		
		Course course1 = repository.findById(1L);
		assertEquals("course1+", course1.getName());
		
	}
	
	@Test
	@DirtiesContext
	public void   playWithEM() {
		repository.playWithEM();
		
	}
	
	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = repository.findById(1L);
		logger.info("test111 " + course.getReviews().toString());
	}
	
	@Test
	@Transactional
	public void retrieveCourseForReview() {
		Review review = em.find(Review.class, 1L);
		logger.info("test111 " + review.toString());
	}
}