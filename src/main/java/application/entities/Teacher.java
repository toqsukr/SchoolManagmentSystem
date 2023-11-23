package application.entities;

import java.util.ArrayList;
import java.util.List;

import application.database.EntityDao;
import application.interfaces.IEntityDao;
import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher extends Person implements IEntityDao<Teacher> {

	public Teacher() {};

	public Teacher(String _name, String _surname, List<Subject> _subjects, List<Klass> _klasses) {
		super(_name, _surname);
		subjects = _subjects;
		klasses = _klasses;
	}

	private static final EntityDao<Teacher> em = new EntityDao<>(Teacher.class);

	public static EntityDao<Teacher> getEntityDao() {
		return em;
	}

	@Id 
	@Column(name = "teacherID") 
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer teacherID;

	public Integer getTeacherID() {
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

	@ManyToMany
	@JoinTable(
			name = "klass_has_teacher",
			joinColumns = {@JoinColumn(name = "teacherID")},
			inverseJoinColumns = {@JoinColumn(name = "klassName")}
	)
	
	private List<Klass> klasses = new ArrayList<>();

	public List<Klass> getKlasses() {
		return klasses;
	}

	public void appendKlass(Klass klass) {
		klasses.add(klass);
	}
}
