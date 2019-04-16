package com.in28minutes.jpa.hibernate.demo.entiry;

import javax.persistence.*;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "passport_id")
	private Passport passport;
	
	public Student() {
	
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(String name, Passport passport) {
		this.name = name;
		this.passport = passport;
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
	
	public Passport getPassport() {
		return passport;
	}
	
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	@Override
	public String toString() {
		return "Student{" +
				       "id=" + id +
				       ", name='" + name + '\'' +
				       '}';
	}
}
