package entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher extends Person {

	public Teacher() {};

	public Teacher(String _name, String _surname, Subject subject) {
		super(_name, _surname);
		appendSubject(subject);
	}

	@Id 
	@Column(name = "teacherID") 
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int teacherID;

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int id) {
		teacherID = id;
	}

	@ManyToMany
    @JoinTable(
        name = "subject_has_teacher",
        joinColumns = {@JoinColumn(name = "teacherID")},
        inverseJoinColumns = {@JoinColumn(name = "subjectName")}
    )
	
	private List<Subject> subjects = new ArrayList<>();

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void appendSubject(Subject subject) {
		subjects.add(subject);
	}
		
}
