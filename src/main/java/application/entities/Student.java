package application.entities;
import java.util.ArrayList;
import java.util.List;

import application.database.EntityDao;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student extends Person {	

	public Student() {};

	public Student(String _name, String _surname, Klass klass) {
		super(_name, _surname);
		setKlass(klass);
	}

	private static final EntityDao<Student> em = new EntityDao<>(Student.class);

	public static EntityDao<Student> getEntityDao() {
		return em;
	}

	@Id 
	@Column(name = "studentID") 
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer studentID;

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(int id) {
		studentID = id;
	}

	@ManyToOne()
	@JoinColumn(name = "klassName")

	private Klass klass;

	public Klass getKlass() {
		return klass;
	}

	public void setKlass(Klass _klass) {
		klass = _klass;
	}
	
	@OneToMany(mappedBy = "progressID.student")
    private List<Progress> progress = new ArrayList<>();

	public List<Progress> getProgress() {
		return progress;
	}
}
