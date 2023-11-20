package com.course.classes;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class Person {
	@Column(name = "name")
	private String name;

	public void setName(String _name) {
		this.name = _name;
	}
	
	public String getName() {
		return name;
	}

	@Column(name = "surname")
	private String lastname;

	public void setLastname(String _lastname) {
		this.lastname = _lastname;
	}
	
	public String getLastname() {
		return lastname;
	}
}