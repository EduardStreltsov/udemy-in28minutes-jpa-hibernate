package com.in28minutes.jpa.hibernate.demo.reposetory;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class JPQLTest{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test
	public void jpql_basic() {
		Query query = em.createQuery("SELECT c FROM Course c");
		List resultList = query.getResultList();
		logger.info("SELECT c FROM Course c -> {}", resultList);
	}
	
	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("SELECT c FROM Course c (typed) -> {}", resultList);
	}
	
	@Test
	public void jpql_where(){
//		TypedQuery<Course> query = em.createQuery("select c from course c where name like '%+%'", Course.class);
//		List<Course> resultList = query.getResultList();
//		logger.info("select c from course c where name like '%+%' -> {}", resultList);
	}
}
