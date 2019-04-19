package com.in28minutes.jpa.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EmployeeType")
public abstract class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	public Employee() {
	}
	
	public Employee(String name) {
		this.name = name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Course{" +
				       "id=" + id +
				       ", name='" + name + '\'' +
				       '}';
	}
	
}
