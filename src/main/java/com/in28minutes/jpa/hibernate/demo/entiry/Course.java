package com.in28minutes.jpa.hibernate.demo.entiry;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@OneToMany
	private List<Review> reviews = new ArrayList<>();
	
	protected Course() {
	}
	
	public Course(String name) {
		this.name = name;
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
	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	@Override
	public String toString() {
		return "Course{" +
				       "id=" + id +
				       ", name='" + name + '\'' +
				       '}';
	}
}
