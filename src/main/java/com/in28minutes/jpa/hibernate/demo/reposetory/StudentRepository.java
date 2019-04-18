package com.in28minutes.jpa.hibernate.demo.reposetory;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class StudentRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	
	@Transactional
	public Student save(Student student) {
		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}
	
	@Transactional
	public boolean deleteById(Long id) {
		Student student = em.find(Student.class, id);
		if (student == null) {
			return false;
		}
		em.remove(student);
		return true;
	}
	
	@Transactional
	public void saveStudentWithPassport() {
		Passport passport = new Passport("1234");
		em.persist(passport);
		Student student = new Student("Mike", passport);
		em.persist(student);
////		student.setNumber(null);
//		logger.info("playWithEM");
	}
	
	@Transactional
	public void understandPC() {
		Student student = em.find(Student.class, 1L);
		Passport passport = student.getPassport();
		passport.setNumber("12345");
		student.setName("Ragul");
	}
	
	@Transactional
	public void insertStudentAndCourse() {
		Student student = new Student("insertStudentAndCourse");
		student.setId(10L);
		Course course = new Course("insertStudentAndCourse");
		course.setId(10L);
		em.persist(course);
		em.persist(student);
		
		student.addCourse(course);
		course.addStudent(student);
		//		em.persist(student);
	}
	
}
