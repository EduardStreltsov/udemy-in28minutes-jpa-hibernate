package com.in28minutes.jpa.hibernate.demo.entiry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;
	private String rating;
	private String description;
	
	@ManyToOne
	private Course course;
	
	public Review() {
	
	}
	
	public Review(String rating, String description) {
		this.rating = rating;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Review{" +
				       "id=" + id +
				       ", rating='" + rating + '\'' +
				       ", description='" + description + '\'' +
				       '}';
	}
}
