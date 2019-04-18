package com.in28minutes.jpa.hibernate.demo.reposetory;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	@Transactional
	public Course save(Course course) {
		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return course;
	}
	
	@Transactional
	public boolean deleteById(Long id) {
		Course course = em.find(Course.class, id);
		if (course == null) {
			return false;
		}
		em.remove(course);
		return true;
	}
	
	@Transactional
	public void playWithEM() {
		Course course = new Course("c1");
		em.persist(course);
//		course.setNumber(null);
		logger.info("playWithEM");
	}
	
	@Transactional
	public void addReviewsForCourse() {
		Course course = findById(3L);
		logger.info("TEST " + course.getReviews().toString());
		
		Review review = new Review("5", "ok");
		review.setId(4L);
		Review review2 = new Review("4", "ok ok");
		review2.setId(5L);
		
		course.addReview(review);
		review.setCourse(course);
		course.addReview(review2);
		review2.setCourse(course);
		
		em.persist(review);
		em.persist(review2);
	}
	
	@Transactional
	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);
		logger.info("TEST " + course.getReviews().toString());
		
		for (Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}
	}
}
