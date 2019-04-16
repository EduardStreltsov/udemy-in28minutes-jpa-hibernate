package com.in28minutes.jpa.hibernate.demo.reposetory;

import com.in28minutes.jpa.hibernate.demo.entiry.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

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
	
}
