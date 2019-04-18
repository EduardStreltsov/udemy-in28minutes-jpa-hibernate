package com.in28minutes.jpa.hibernate.demo.entity;

import javax.persistence.*;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String number;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
//	@JoinColumn(name = "student_id")
	private Student student;
	
	public Passport() {
	
	}
	
	public Passport(String number) {
		this.number = number;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public String toString() {
		return "Passport{" +
				       "id=" + id +
				       ", number='" + number + '\'' +
				       ", student=" + student +
				       '}';
	}
}
