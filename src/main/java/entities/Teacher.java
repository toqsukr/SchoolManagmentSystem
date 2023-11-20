package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher extends Person {

	public Teacher(String _name, String _surname, Subject subject) {
		super(_name, _surname);
		setSubject(subject);
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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subjectName", referencedColumnName = "subjectName")

	private Subject subject;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject _subject) {
		subject = _subject;
	}
		
}
