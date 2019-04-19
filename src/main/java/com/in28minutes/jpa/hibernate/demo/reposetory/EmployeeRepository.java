package com.in28minutes.jpa.hibernate.demo.reposetory;

import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public void insert(Employee employee) {
		em.persist(employee);
	}
	
	public Employee findById(Long id) {
		return em.find(Employee.class, id);
	}
	
	public List<Employee> findAll() {
		return em.createQuery("select e from employee e", Employee.class).getResultList();
	}
	
}
