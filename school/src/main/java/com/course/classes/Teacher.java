package com.course.classes;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "Teacher")
public class Teacher extends Person {
	@Id 
	@Column(name = "id") 
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "klass_has_teacher",
        joinColumns = {@JoinColumn(name = "teacherID")},
        inverseJoinColumns = {@JoinColumn(name = "groupID")}
    )
	private List<Group> groups = new ArrayList<>();

	public List<Group> getGroups() {
		return groups;
	}

	public void addGroup(Group gr) {
		this.groups.add(gr);
	}

	@Column(name = "experience")

	private Integer experience;

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer exp) {
		this.experience = exp;
	}

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "teacher_has_subject",
        joinColumns = {@JoinColumn(name = "teacherID")},
        inverseJoinColumns = {@JoinColumn(name = "subjectID")}
    )
	private List<Subject> subjects = new ArrayList<>();

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void addSubject(Subject sub) {
		this.subjects.add(sub);
	}
	
	// public Group[] getGroups() {
	// 	return groups;
	// 
	// public void deleteSubject() {}
	// public void deleteGroup() {}
	
}
