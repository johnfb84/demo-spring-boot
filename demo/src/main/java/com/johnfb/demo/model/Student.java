package com.johnfb.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
	
	private UUID id;
	private final String firstName;
	private final String lastName;
	private final String course;
	private final Integer age;
	
	public Student(
			@JsonProperty("id") UUID id, 
			@JsonProperty("firstName") String firstName, 
			@JsonProperty("lastName") String lastName, 
			@JsonProperty("course") String course, 
			@JsonProperty("age") Integer age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.age = age;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getCourse() {
		return course;
	}
	public Integer getAge() {
		return age;
	}
	
	

}
