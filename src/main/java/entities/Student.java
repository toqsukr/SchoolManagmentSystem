package entities;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student extends Person {	

	public Student(String _name, String _surname, Klass klass) {
		super(_name, _surname);
		setKlass(klass);
	}

	@Id 
	@Column(name = "studentID") 
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int studentID;

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int id) {
		studentID = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "klassName", referencedColumnName = "klassName")

	private Klass klass;

	public Klass getKlass() {
		return klass;
	}

	public void setKlass(Klass _klass) {
		klass = _klass;
	}
	
	@OneToMany(mappedBy = "progressID.student", cascade = CascadeType.ALL)
    private List<Progress> progress = new ArrayList<>();

	public List<Progress> getProgress() {
		return progress;
	}
}
