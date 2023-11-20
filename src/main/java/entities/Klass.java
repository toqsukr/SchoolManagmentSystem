package entities;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "klass")
public class Klass {

	public Klass() {};
	
	public Klass(String _name) {
		this.setKlassName(_name);
	}
	
	@Id 
	@Column(name = "klassName") 
	private String name; 

	public String getKlassName() {
		return name;
	}

	public void setKlassName(String _name) {
		this.name = _name;
	}

	@OneToMany(mappedBy = "klass")
	private List<Student> students = new ArrayList<>();


	@ManyToMany
	@JoinTable(
			name = "klass_has_teacher",
			joinColumns = {@JoinColumn(name = "klassName")},
			inverseJoinColumns = {@JoinColumn(name = "teacherID")}
	)
	
	private List<Teacher> teachers = new ArrayList<>();

	public List<Teacher> getTeachers() {
		return teachers;
	}
}
