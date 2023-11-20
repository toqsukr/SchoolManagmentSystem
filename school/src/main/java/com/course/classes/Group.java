package com.course.classes;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "Group")
public class Group {
	
	@Id 
	@Column(name = "id") 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "name")
	private String name; 

	public void setName(String _name) {
		// исключение на пустое имя
		this.name = _name;
	}
	
	public String getName() {
		return name;
	}

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "klass_has_teacher",
        joinColumns = {@JoinColumn(name = "groupID")},
        inverseJoinColumns = {@JoinColumn(name = "teacherID")}
    )
	
	private List<Teacher> teachers = new ArrayList<>();

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void addTeacher(Teacher teach) {
		this.teachers.add(teach);
	}

	// private List<Student> students = new ArrayList<>();
	
	// public void addStudent(Student stud) {
	// 	this.students.add(stud);
	// }

	// public void setTeachers(List<Teacher> teachers) {
	// 	this.teachers = teachers;
	// }

	// private Integer numberOfStudents;
	// public Integer getGroupSize() {
	// 	return numberOfStudents;
	// }
	
	// public Student[] getStudents() {
	// 	return students;
	// }
	
	// public void addStudent(Student somestudent) {}
	// public void deleteStudent() {}
}
